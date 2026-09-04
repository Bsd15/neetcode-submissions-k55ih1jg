class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(t -> t[1]));
        PriorityQueue<Integer> dropOffQ = new PriorityQueue<>((t1, t2) -> trips[t1][2] - trips[t2][2]);
        int passengerCount = 0;
        for(int i = 0; i < trips.length; i++) {
            
            while (!dropOffQ.isEmpty() && trips[i][1] >= trips[dropOffQ.peek()][2]) {
                int dropTripIdx = dropOffQ.poll();
                passengerCount -= trips[dropTripIdx][0];
            }

            passengerCount += trips[i][0];
            if (passengerCount > capacity) {
                return false;
            }
            dropOffQ.add(i);
        }

        return true;
    }
}