class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int total = 0;
        for (int n: nums) {
            max = Math.max(max, n);
            total += n;
        }

        int l = max;
        int r = total;
        int res = 0;

        while (l <= r) {
            int m = l + ((r - l)/2);
            if (canSplit(nums, m, k)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    private boolean canSplit(int[] nums, int expectedSum, int k) {
        int currSum = 0;
        int splits = 1;
        for (int n: nums) {
            if (currSum + n > expectedSum) {
                ++splits;
                currSum = n;
            } else {
                currSum += n;
            }
        }
        return splits <= k;
    }
}