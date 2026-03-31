class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        n = len(nums)
        for i in range(n - 2):
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            l = i + 1
            r = n - 1
            while l < r:
                three_sum = nums[i] + nums[l] + nums[r]
                if three_sum == 0:
                    res.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l + 1] == nums[l]:
                        l += 1
                    l += 1
                    while l < r and nums[r - 1] == nums[r]:
                        r -= 1
                    r -= 1
                elif three_sum < 0:
                    l += 1
                else:
                    r -= 1
        return res
