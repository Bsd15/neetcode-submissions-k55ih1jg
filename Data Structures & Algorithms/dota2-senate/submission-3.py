class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        radiants = []
        dires = []
        for i,s in enumerate(senate):
            if s == 'R':
                heapq.heappush(radiants, i)
            else:
                heapq.heappush(dires, i)
        n = len(senate)
        while radiants and dires:
            if radiants[0] < dires[0]:
                i = heapq.heappop(radiants)
                # n -= 1
                heapq.heappush(radiants, i + n)
                heapq.heappop(dires)
            else:
                i = heapq.heappop(dires)
                # n -= 1
                heapq.heappush(dires, i + n)
                heapq.heappop(radiants)
        return 'Radiant' if not dires else 'Dire'