class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        
        rows = len(matrix)
        cols = len(matrix[0])

        new_matrix = []

        for r in range(rows + 1):
            row = [0] * (cols + 1)
            new_matrix.append(row)

        for r in range(rows):
            prefix_sum = 0
            for c in range(cols):
                prefix_sum += matrix[r][c]
                new_matrix[r + 1][c + 1] = prefix_sum + new_matrix[r][c+1]
        self.matrix = new_matrix

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        row1 += 1
        col1 += 1
        row2 += 1
        col2 += 1

        left_diff = self.matrix[row2][col1 - 1]
        top_diff = self.matrix[row1-1][col2]
        corner = self.matrix[row1-1][col1-1]

        res = self.matrix[row2][col2]

        return res - left_diff - top_diff + corner


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)