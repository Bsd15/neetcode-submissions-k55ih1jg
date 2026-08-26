class Twitter:

    def __init__(self):
        self.count = 0
        self.users = {}
        self.user_posts = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.user_posts:
            self.user_posts[userId] = []
        self.count += 1
        self.user_posts[userId].append((self.count, tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:
        heap = []
        feed = []

        if userId not in self.users:
            self.users[userId] = set()
        self.users[userId].add(userId)

        for followee in self.users[userId]:
            if followee in self.user_posts and self.user_posts[followee]:
                index = len(self.user_posts[followee]) - 1
                count, tweetId = self.user_posts[followee][index]
                heapq.heappush_max(heap, (count, tweetId, followee, index))
        
        while heap and len(feed) < 10:
            count, tweetId, followeeId, index = heapq.heappop_max(heap)
            feed.append(tweetId)
            next_index = index - 1
            if next_index >= 0:
                count, tweetId = self.user_posts[followeeId][next_index]
                heapq.heappush_max(heap, (count, tweetId, followeeId, next_index))
        return feed


    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.users:
            self.users[followerId] = set()
        self.users[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.users:
            self.users[followerId] = set()
        self.users[followerId].discard(followeeId)
        
