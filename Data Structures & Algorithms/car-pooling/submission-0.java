class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips.length == 1) {
            return true;
        }
        PriorityQueue<Integer> pickUpQ = new PriorityQueue<>((t1, t2) -> trips[t1][1] - trips[t2][1]);
        PriorityQueue<Integer> dropOffQ = new PriorityQueue<>((t1, t2) -> trips[t1][2] - trips[t2][2]);
        int passengerCount = 0;
        int currLocation = 0;
        for (int i = 0; i < trips.length; i++) {
            if (trips[i][0] > capacity)
                return false;
            pickUpQ.add(i);
        }

        while (!pickUpQ.isEmpty()) {
            int tripIdx = pickUpQ.poll();
            currLocation = trips[tripIdx][1];
            while (!dropOffQ.isEmpty() && currLocation >= trips[dropOffQ.peek()][2]) {
                int dropTripIdx = dropOffQ.poll();
                passengerCount -= trips[dropTripIdx][0];
            }

            passengerCount += trips[tripIdx][0];
            if (passengerCount > capacity) {
                return false;
            }
            dropOffQ.add(tripIdx);
        }

        return true;
    }
}