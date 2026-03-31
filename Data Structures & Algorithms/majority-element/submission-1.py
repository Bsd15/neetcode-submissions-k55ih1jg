class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        current = nums[0]
        count = 1

        for i in range(1, len(nums)):
            if current == nums[i]:
                count += 1
            else:
                count -= 1
            if count == 0:
                current = nums[i]
                count = 1

        return current