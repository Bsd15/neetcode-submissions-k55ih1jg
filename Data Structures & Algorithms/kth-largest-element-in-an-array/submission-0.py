import random
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        left = 0
        right = len(nums) - 1
        index = len(nums) - k
        while left <= right:
            pivot = self.partition(nums, left, right)
            if pivot < index:
                left = pivot + 1
            elif pivot > index:
                right = pivot - 1
            else:
                return nums[pivot]
        return -1
    
    def partition(self, nums: List[int], left: int, right: int) -> int:
        random_index = random.randint(left, right)
        nums[right], nums[random_index] = nums[random_index], nums[right]
        pivot = nums[right]
        largest = left
        for i in range(left, right):
            if nums[i] < pivot:
                nums[largest], nums[i] = nums[i], nums[largest]
                largest += 1
        nums[largest], nums[right] = nums[right], nums[largest]
        return largest
        
