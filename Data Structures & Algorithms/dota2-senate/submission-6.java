class Solution {
    public String predictPartyVictory(String senate) {
        int nR = 0, nD = 0, eR = 0, eD = 0;
        Deque<Character> deque = new ArrayDeque<>(senate.length());
        for (char vote: senate.toCharArray()) {
            if (vote == 'R') {
                if (eR > 0) {
                    --eR;
                } else {
                    ++nR;
                    ++eD;
                    deque.offerLast('R');
                }
            } else {
                if (eD > 0) {
                    --eD;
                } else {
                    ++nD;
                    ++eR;
                    deque.offerLast('D');
                }
            }
        }

        while ((nR > 0) && (nD > 0)) {
            char vote = deque.pollFirst();
            if (vote == 'R') {
                if (eR > 0) {
                    --eR;
                    --nR;
                } else {
                    deque.offerLast('R');
                    ++eD;
                }
            } else {
                if (eD > 0) {
                    --eD;
                    --nD;
                } else {
                    deque.offerLast('D');
                    ++eR;
                }
            }
        }

        return nD == 0 ? "Radiant" : "Dire";
    }
}