class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        if n == k:
            return arr

        closest = 1
        closest_dist = abs(arr[0] - x)

        # find closest
        for i in range(1, n):
            curr_dist = abs(arr[i] - x)
            if curr_dist < closest_dist:
                closest_dist = curr_dist
                closest = i
        
        # use sliding window to find k elements
        # expand left or right until k elements are captured
        l = closest
        r = closest
        while (r - l + 1) < k:
            left_dist = sys.maxsize
            right_dist = sys.maxsize
            if l > 0:
                left = l - 1
                left_dist = abs(arr[left] - x)
            if r < n - 1:
                right = r + 1
                right_dist = abs(arr[right] - x)
            
            if left_dist <= right_dist:
                l -= 1
            else:
                r += 1
        
        return arr[l:r + 1]
