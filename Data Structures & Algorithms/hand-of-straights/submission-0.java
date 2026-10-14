class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int h: hand) {
            map.merge(h, 1, Integer::sum);
        }
        
        // System.out.println(map.toString());
        int groups = hand.length / groupSize;
        for (int g = 0; g < groups; g++) {
            int key = map.firstKey();
            int currGrpSize = 1;
            while (currGrpSize <= groupSize) {
                if (!map.containsKey(key)) {
                    return false;
                }
                map.compute(key, (k, v) -> v == 1 ? null : v - 1);
                currGrpSize++;
                key++;
            }
        }
        return true;
    }
}
