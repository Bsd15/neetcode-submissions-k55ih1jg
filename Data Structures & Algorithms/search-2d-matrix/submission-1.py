class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])

        size = m * n

        l,r = 0, size - 1

        while l <= r:
            m = l + (r - l) // 2
            x = m//n
            y = m%n

            if matrix[x][y] == target:
                return True
            elif matrix[x][y] < target:
                l = m + 1
            else:
                r = m - 1
        return False