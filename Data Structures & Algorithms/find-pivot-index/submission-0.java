class Solution {
    public int pivotIndex(int[] nums) {
        // 1, 7, 3, 6, 5, 6
        // 1  8 11 18 23 29
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int r = prefix.length - 1;
        for (int i = 1; i < prefix.length; i++) {
            int rightSideSum = prefix[r] - prefix[i];
            int leftSideSum = prefix[i - 1];
            if (leftSideSum == rightSideSum) {
                return i - 1;
            }
        }

        return -1;

    }
}