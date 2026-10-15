class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> rQ = new ArrayDeque<>(n);
        Deque<Integer> dQ = new ArrayDeque<>(n);

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQ.addLast(i);
            } else {
                dQ.addLast(i);
            }
        }

        while (!rQ.isEmpty() && !dQ.isEmpty()) {
            int r = rQ.removeFirst();
            int d = dQ.removeFirst();
            if (r < d) {
                rQ.addLast(r + n);
            } else {
                dQ.addLast(d + n);
            }
        }

        return rQ.isEmpty() ? "Dire" : "Radiant";
    }
}