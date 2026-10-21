class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') {
            return false;
        }
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int outgoing = i - maxJump - 1;
            int incomming = i - minJump;
            if (outgoing >= 0 && dp[outgoing]) count--;
            if (incomming >= 0 && dp[incomming]) count++;
            if (count > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
            // System.out.println("i: " + i + " outgoing: " + outgoing + " incomming: " + incomming + " count: " + count);
        }
        // System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}