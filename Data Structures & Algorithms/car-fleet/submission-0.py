class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        times = [0] * target
        for p,s in zip(position, speed):
            times[p] = (target - p) / s
        res = 0
        prev = 0
        for i in range(len(times) - 1, -1, -1):
            curr = times[i]
            if curr > prev:
                prev = curr
                res += 1
        return res