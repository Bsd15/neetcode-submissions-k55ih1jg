class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> t2[0] - t1[0]);
        if (a > 0) {
            pq.offer(new int[] {a, 'a'});
        }
        if (b > 0) {
            pq.offer(new int[] {b, 'b'});
        }
        if (c > 0) {
            pq.offer(new int[] {c, 'c'});
        }
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int currLen = sb.length();
            if (sb.length() > 1 && sb.charAt(currLen - 2) == sb.charAt(currLen - 1)
                && sb.charAt(currLen - 1) == ((char) next[1])) {
                if (pq.isEmpty()) {
                    break;
                }
                int[] next2 = pq.poll();
                sb.append((char) next2[1]);
                next2[0] -= 1;
                if (next2[0] > 0) {
                    pq.offer(next2);
                }
                pq.offer(next);
            } else {
                sb.append((char) next[1]);
                next[0] -= 1;
                if (next[0] > 0) {
                    pq.offer(next);
                }
            }
        }

        return sb.toString();
    }
}