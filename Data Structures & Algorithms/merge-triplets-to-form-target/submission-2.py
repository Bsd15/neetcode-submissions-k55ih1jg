class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        res = [0] * 3
        for t in triplets:
            if t[0] > target[0] or t[1] > target[1] or t[2] > target[2]:
                continue
            res[0] = max(res[0], t[0])
            res[1] = max(res[1], t[1])
            res[2] = max(res[2], t[2])
            if res == target:
                return True
        return False