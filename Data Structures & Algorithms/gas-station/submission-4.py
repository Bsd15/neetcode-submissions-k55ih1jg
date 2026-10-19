class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total_gas = curr_gas = res = 0
        for i in range(len(gas)):
            total_gas += gas[i] - cost[i]
            curr_gas += gas[i] - cost[i]
            if curr_gas < 0:
                curr_gas = 0
                res = (i + 1)
        if total_gas < 0:
            return -1
        return res