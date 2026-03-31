class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def get_index(i: int, col: int):
            return [i//col, i%col]
        rows = len(matrix)
        cols = len(matrix[0])
        l = 0
        r = (rows * cols) - 1
        while l <= r:
            m = l + (r - l) // 2
            x,y = get_index(m, cols)
            if matrix[x][y] == target:
                return True
            elif matrix[x][y] < target:
                l = m + 1
            else:
                r = m - 1
        return False