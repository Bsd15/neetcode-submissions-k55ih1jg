class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if k == 1:
            return nums
        deque = []
        res = []
        for i,e in enumerate(nums):
            while deque and deque[-1] < e:
                deque.pop(-1)
            deque.append(e)
            if i > k - 1 and nums[i - k] == deque[0]:
                deque.pop(0)
            if i >= k - 1:
                res.append(deque[0])
        return res