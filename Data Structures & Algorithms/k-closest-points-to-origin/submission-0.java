class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // (x1, y1) = (0, 0)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingDouble(Solution::euclidDistanceToOrigin));
        Collections.addAll(pq, points);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    private static double euclidDistanceToOrigin(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
