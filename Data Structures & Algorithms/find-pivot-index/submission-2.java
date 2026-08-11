class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int n: nums){
            totalSum += n;
        }
        
        int currSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int leftSideSum = currSum;
            currSum += nums[i];
            int rightSideSum = totalSum - currSum;
            if (leftSideSum == rightSideSum) {
                return i;
            }
        }

        return -1;
    }
}