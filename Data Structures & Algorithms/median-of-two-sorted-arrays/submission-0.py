class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        x = len(nums1)
        y = len(nums2)
        if x > y:
            return self.findMedianSortedArrays(nums2, nums1)
        
        left = 0
        right = x
        first_half_elements_len = (x + y + 1) // 2
        while left <= right:
            partition_x = left + ((right - left) // 2)
            partition_y = first_half_elements_len - partition_x

            left_x = nums1[partition_x - 1] if partition_x > 0 else -float("inf")
            right_x = nums1[partition_x] if partition_x < x else float("inf")

            left_y = nums2[partition_y - 1] if partition_y > 0 else -float("inf")
            right_y = nums2[partition_y] if partition_y < y else float("inf")

            if left_x <= right_y and left_y <= right_x:
                if (x + y) % 2 != 0:
                    return max(left_x, left_y)
                else:
                    return (max(left_x, left_y) + min(right_x, right_y)) / 2
            elif left_x > right_y:
                right = partition_x - 1
            else:
                left = partition_x + 1
