class Solution {
    public int maxScore(String s) {
        int ones = 0;
        for (char c: s.toCharArray()) {
            if (c == '1')
                ++ones;
        }

        int zeros = 0;
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                --ones;
            } else {
                ++zeros;
            }

            res = Math.max(res, zeros + ones);
        }
        return res;
    }
}