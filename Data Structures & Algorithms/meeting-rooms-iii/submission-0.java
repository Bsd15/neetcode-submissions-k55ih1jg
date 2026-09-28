class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        int[] usageCount = new int[n];
        PriorityQueue<int[]> currMeetings = new PriorityQueue<>((m1, m2) -> m1[1] == m2[1] ? m1[0] - m2[0] : m1[1] - m2[1]);
        Arrays.sort(
                meetings,
                (m1, m2) -> m1[0] == m2[0] ? m1[1] - m2[1] : m1[0] - m2[0]
        );
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        for (int[] meeting: meetings) {
            int start = meeting[0], end = meeting[1];
            while (!currMeetings.isEmpty() && currMeetings.peek()[1] <= start) {
                freeRooms.offer(
                        currMeetings.poll()[0]
                );
            }

            if (freeRooms.isEmpty()) {
                int[] currMeet = currMeetings.poll();
                freeRooms.offer(currMeet[0]);
                end = currMeet[1] + (end - start);
            }

            int room = freeRooms.poll();
            currMeetings.offer(
                    new int[] {room, end}
            );
            ++usageCount[room];
        }

        int maxRoomId = 0;
        for (int i = 0; i < n; i++) {
            if (usageCount[maxRoomId] < usageCount[i]) {
                maxRoomId = i;
            }
        }
        return maxRoomId;
    }
}