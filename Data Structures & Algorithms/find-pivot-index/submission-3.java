class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int n: nums){
            totalSum += n;
        }
        
        int leftSideSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int rightSideSum = totalSum - leftSideSum - nums[i];
            if (leftSideSum == rightSideSum) {
                return i;
            }
            leftSideSum += nums[i];
        }

        return -1;
    }
}