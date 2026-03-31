class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;

        // Prefix product scan
        int product = nums[0];
        for (int i = 1; i < n; i++) {
            answer[i] = product;
            product *= nums[i];
        }

        // Suffix product scan
        product = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product *= nums[i];
        }

        return answer;
    }
}