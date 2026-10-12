class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] reachable = new boolean[s.length()];
        reachable[0] = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i - minJump;
            if (left >= 0 && reachable[left]) {
                count++;
            }
            
            int right = i - maxJump - 1;
            if (right >= 0 && reachable[right]) {
                count--;
            }

            if (count > 0 && s.charAt(i) == '0') {
                reachable[i] = true;
            }
        }
        return reachable[reachable.length - 1];
    }
}