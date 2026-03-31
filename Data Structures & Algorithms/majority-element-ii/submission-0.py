class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        current1 = 0
        count1 = 0
        current2 = 0
        count2 = 0

        for n in nums:
            if current1 == n:
                count1 += 1
            elif current2 == n:
                count2 += 1
            elif count1 == 0:
                current1 = n
                count1 = 1
            elif count2 == 0:
                current2 = n
                count2 = 1
            else:
                count1 -= 1
                count2 -= 1
        
        count1 = 0
        count2 = 0

        for n in nums:
            if n == current1:
                count1 += 1
            if n == current2:
                count2 += 1
        
        res = []
        if count1 > len(nums) // 3:
            print(f"count1: {count1}")
            res.append(current1)
        if count2 > len(nums) // 3:
            print(f"count2: {count2}")
            res.append(current2)
        return res