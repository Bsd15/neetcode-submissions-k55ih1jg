class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = len(board)
        cols = len(board[0])

        rows_set = [set() for r in range(rows)]
        cols_set = [set() for c in range(cols)]
        grids_set = [set() for g in range(rows)]
        
        for r in range(rows):
            for c in range(cols):
                g = (r//3) * 3 + (c//3)
                num = board[r][c]
                if num == ".":
                    continue
                else:
                    num = int(num)
                if num in rows_set[r] or num in cols_set[c] or num in grids_set[g]:
                    return False
                rows_set[r].add(num)
                cols_set[c].add(num)
                grids_set[g].add(num)
                
        return True