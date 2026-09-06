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

        int[] coolDown = null;

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if (next[0] == 0)
                continue;
            if (coolDown != null) {
                pq.offer(coolDown);
                coolDown = null;
            }

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == next[1]) {
                sb.append((char)next[1]);
                next[0] -= 1;
                coolDown = next;
            } else {
                sb.append((char)next[1]);
                next[0] -= 1;
                pq.offer(next);
            }
        }

        return sb.toString();
    }
}