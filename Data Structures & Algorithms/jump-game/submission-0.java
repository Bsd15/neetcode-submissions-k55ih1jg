class Solution {
    public boolean canJump(int[] nums) {
        int[] nextJump = new int[nums.length];
        int bestIndex = nums.length - 1;
        for (int i = nums.length - 1; i > -1; i--) {
            if (i + nums[i] >= bestIndex) {
                nextJump[i] = bestIndex;
                bestIndex = i;
            } else {
                nextJump[i] = -1;
            }
        }

        if (nextJump[0] == -1) {
            return false;
        } else {
            return true;
        }
    }
}
