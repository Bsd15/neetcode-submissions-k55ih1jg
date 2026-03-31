class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        visited = {}
        for i,e in enumerate(nums):
            if e in visited:
                return [visited[e], i]
            visited[target - e] = i
        return []