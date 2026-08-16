class Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for (int num: nums) {
            total += num;
        }
        final int remainder = total % p;

        if (remainder == 0) {
            return 0;
        }

        int result = nums.length;

        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);

        int currRemainder = 0;
        for (int i = 0; i < nums.length; i++) {
            currRemainder = (currRemainder + nums[i]) % p;
            int requiredRemainder = (currRemainder - remainder + p) % p;
            if (remainderMap.containsKey(requiredRemainder)) {
                result = Math.min(
                    result,
                    i - remainderMap.get(requiredRemainder)
                );
            }
            remainderMap.put(currRemainder, i);
        }

        return result == nums.length ? -1 : result;
    }
}