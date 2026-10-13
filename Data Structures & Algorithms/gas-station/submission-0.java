class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        for (int g: gas)
            totalGas += g;
        int totalCost = 0;
        for (int c: cost)
            totalCost += c;
        if (totalGas < totalCost) {
            return -1;
        }

        int startIdx = 0, currGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i];
            if (currGas < cost[i]) {
                currGas = 0;
                startIdx = (i + 1);
            } else {
                currGas -= cost[i];
            }
        }
        return startIdx;
    }
}
