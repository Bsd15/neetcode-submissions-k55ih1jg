class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0], globalMin = nums[0];
        int currMax = 0, currMin = 0;
        int total = 0;
        for (int n: nums) {
            currMax = Math.max(currMax + n, n);
            currMin = Math.min(currMin + n, n);
            total += n;
            globalMax = Math.max(currMax, globalMax);
            globalMin = Math.min(currMin, globalMin);
        }

        if (globalMax > 0) {
            return Math.max(globalMax, total - globalMin);
        } else {
            return globalMax;
        }
    }
}

/**
gMax -2 cMax 4
gMin -2 cMin 2
total = -2
*/