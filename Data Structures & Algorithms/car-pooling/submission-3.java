class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int[] trip : trips) {
            start = Math.min(start, trip[1]);
            end = Math.max(end, trip[2]);
        }

        int n = end - start + 1;
        int[] drops = new int[n + 1];
        for (int[] trip : trips) {
            drops[trip[1] - start] = drops[trip[1] - start] + trip[0];
            drops[trip[2] - start] = drops[trip[2] - start] - trip[0];
        }

        int currCap = 0;
        for (int i = 0; i < drops.length; i++) {
            currCap = currCap + drops[i];
            if (currCap > capacity) {
                return false;
            }
        }

        return true;
    }
}