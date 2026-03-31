class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        visited = {}
        for i,n in enumerate(nums):
            if n in visited:
                if abs(i - visited[n]) <= k:
                    return True
            visited[n] = i
        return False