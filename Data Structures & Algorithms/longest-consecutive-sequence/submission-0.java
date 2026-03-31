class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int result = 0;
        for (int n : nums) {
            if (!numsMap.containsKey(n)) {
                int left = numsMap.getOrDefault(n - 1, 0);
                int right = numsMap.getOrDefault(n + 1, 0);
                int sum = left + right + 1;
                result = Math.max(result, sum);
                numsMap.put(n, sum);
                numsMap.put(n - left, sum);
                numsMap.put(n + right, sum);
            }
        }
        return result;
    }
}
