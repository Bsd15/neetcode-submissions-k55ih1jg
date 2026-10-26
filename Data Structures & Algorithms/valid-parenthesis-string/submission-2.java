class Solution {
    public boolean checkValidString(String s) {
        int minReq = 0, maxReq = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                ++minReq;
                ++maxReq;
            } else if (c == ')') {
                --minReq;
                --maxReq;
            } else {
                --minReq;
                ++maxReq;
            }

            minReq = Math.max(minReq, 0);

            if (maxReq < 0) {
                return false;
            }
        }

        return minReq == 0;
    }
}
