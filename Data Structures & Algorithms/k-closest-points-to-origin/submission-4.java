class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // (x1, y1) = (0, 0)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(Solution::euclidDistanceToOrigin).reversed());
        for (int[] p: points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    private static int euclidDistanceToOrigin(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}
