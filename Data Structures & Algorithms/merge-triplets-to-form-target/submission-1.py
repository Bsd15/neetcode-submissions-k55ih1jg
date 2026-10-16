class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        curr = [0, 0, 0]
        for triplet in triplets:
            if triplet[0] <= target[0] and triplet[1] <= target[1] and triplet[2] <= target[2]:
                print(triplet)
                curr[0] = max(triplet[0], curr[0])
                curr[1] = max(triplet[1], curr[1])
                curr[2] = max(triplet[2], curr[2])
            if curr[0] == target[0] and curr[1] == target[1] and curr[2] == target[2]:
                return True
            print(curr)
        return False
