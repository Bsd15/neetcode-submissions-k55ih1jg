class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        if n < 4:
            return []
        nums.sort()
        res = []
        for i in range(n - 3):
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            for j in range(i + 1, n - 2):
                if j > i + 1 and nums[j - 1] == nums[j]:
                    continue
                l = j + 1
                r = n - 1
                while l < r:
                    four_sum = nums[i] + nums[j] + nums[l] + nums[r]
                    if four_sum == target:
                        res.append([nums[i], nums[j], nums[l], nums[r]])
                        l += 1
                        r -= 1
                        while l < r and nums[l - 1] == nums[l]:
                            l += 1
                        while l < r and nums[r + 1] == nums[r]:
                            r -= 1
                    elif four_sum < target:
                        l += 1
                    else:
                        r -= 1
        return res