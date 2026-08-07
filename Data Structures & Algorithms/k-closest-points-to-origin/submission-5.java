class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // (x1, y1) = (0, 0)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b)
                -> Integer.compare((b[0] * b[0]) + (b[1] * b[1]), ((a[0] * a[0]) + (a[1] * a[1]))));
        for (int[] p : points) {
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
}
