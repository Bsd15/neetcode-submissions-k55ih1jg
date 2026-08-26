class Twitter:
    def __init__(self):
        self.count = 0  # Global counter to track tweet recency
        self.users = {}  # userId -> set of followeeIds
        self.user_posts = {}  # userId -> list of [count, tweetId]

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.user_posts:
            self.user_posts[userId] = []

        self.count += 1
        # Store negative count so min-heap acts as max-heap for timestamps
        self.user_posts[userId].append([-self.count, tweetId])

    def getNewsFeed(self, userId: int) -> List[int]:
        feed = []
        min_heap = []

        # Ensure the user always follows themselves to include their own posts
        if userId not in self.users:
            self.users[userId] = set()
        self.users[userId].add(userId)

        # Gather the most recent tweet from each followee
        for followeeId in self.users[userId]:
            if followeeId in self.user_posts and self.user_posts[followeeId]:
                index = len(self.user_posts[followeeId]) - 1
                count, tweetId = self.user_posts[followeeId][index]
                # Push: (count, tweetId, followeeId, index_in_user_posts)
                min_heap.append((count, tweetId, followeeId, index))

        heapq.heapify(min_heap)

        # Extract up to 10 most recent tweets overall
        while min_heap and len(feed) < 10:
            count, tweetId, followeeId, index = heapq.heappop(min_heap)
            feed.append(tweetId)

            # If the followee has older tweets, push the next recent one
            if index > 0:
                prev_count, prev_tweetId = self.user_posts[followeeId][index - 1]
                heapq.heappush(min_heap, (prev_count, prev_tweetId, followeeId, index - 1))

        return feed

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.users:
            self.users[followerId] = set()
        self.users[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        # Prevent user from unfollowing themselves
        if followerId in self.users and followeeId != followerId:
            self.users[followerId].discard(followeeId)
