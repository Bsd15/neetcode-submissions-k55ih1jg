class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddPrefixCount = 0, evenPrefixCount = 0, currPrefix = 0, count = 0;

        final int DIVISOR = (int) Math.pow(10, 9) + 7;

        for (int n: arr) {
            currPrefix += n;
            if (currPrefix % 2 != 0) {
                count += 1 + evenPrefixCount;
                ++oddPrefixCount;
            } else {
                count += oddPrefixCount;
                ++evenPrefixCount;
            }
        }

        return count;
    }
}