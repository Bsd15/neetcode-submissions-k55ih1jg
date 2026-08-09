import random
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        left = 0
        right = len(nums) - 1
        index = len(nums) - k
        while left <= right:
            lt, gt = self.partition(nums, left, right)
            if index < lt:
                right = lt - 1
            elif index > gt:
                left = gt + 1
            else:
                return nums[index]
        return -1
    
    def partition(self, nums: List[int], left: int, right: int) -> tuple[int]:
        pivot = nums[random.randint(left, right)]
        lt = left
        gt = right
        i = left
        while i <= gt:
            if nums[i] < pivot:
                nums[lt], nums[i] = nums[i], nums[lt]
                lt += 1
                i += 1
            elif nums[i] > pivot:
                nums[i], nums[gt] = nums[gt], nums[i]
                gt -= 1
            else:
                i += 1
        return lt, gt
        
