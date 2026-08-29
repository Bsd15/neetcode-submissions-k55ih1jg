class Twitter {
    private Map<Integer, Set<Integer>> users;
    private Map<Integer, List<int[]>> userPosts;
    private int count;

    public Twitter() {
        users = new HashMap<>();
        userPosts = new HashMap<>();
        count = 0;
    }

    public void postTweet(int userId, int tweetId) {
        this.userPosts.computeIfAbsent(userId, (k) -> new ArrayList<>())
            .add(new int[] {tweetId, ++count});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] - p1[0]);
        List<int[]> userPosts = this.userPosts.computeIfAbsent(userId, k -> new ArrayList<>());
        if (!userPosts.isEmpty()) {
            int[] latestUserPost = userPosts.getLast();
            pq.add(new int[] {latestUserPost[1], latestUserPost[0], userPosts.size() - 1, userId});
        }

        for (Integer followee : this.users.computeIfAbsent(userId, k -> new HashSet<>())) {
            if (!this.userPosts.containsKey(followee)) {
                continue;
            }

            List<int[]> followeePosts = this.userPosts.get(followee);
            int[] followeeLastPost = followeePosts.getLast();
            pq.add(new int[] {
                followeeLastPost[1], followeeLastPost[0], followeePosts.size() - 1, followee});
        }

        List<Integer> result = new ArrayList<>(10);
        while (result.size() < 10 && !pq.isEmpty()) {
            int[] post = pq.poll();
            result.add(post[1]);
            int nextIdx = post[2] - 1;
            if (nextIdx > -1) {
                List<int[]> followeePosts = this.userPosts.get(post[3]);
                int[] followeeNextPost = followeePosts.get(nextIdx);
                pq.add(new int[] {followeeNextPost[1], followeeNextPost[0], nextIdx, post[3]});
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        this.users.computeIfAbsent(followerId, (k) -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        this.users.computeIfAbsent(followerId, (k) -> new HashSet<>()).remove(followeeId);
    }
}
