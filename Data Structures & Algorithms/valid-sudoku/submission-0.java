class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] rowsScan = new boolean[rows][9];
        boolean[][] colsScan = new boolean[cols][9];
        boolean[][] gridsScan = new boolean[rows][9];

        int grid = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char entry = board[r][c];
                if (entry == '.') {
                    continue;
                }
                int num = entry - '1';
                grid = (r / 3) * 3 + (c / 3);
                if (
                    rowsScan[r][num] 
                    || colsScan[c][num]
                    || gridsScan[grid][num]
                ) {
                    return false;
                } else {
                    rowsScan[r][num] = true;
                    colsScan[c][num] = true;
                    gridsScan[grid][num] = true;
                }
            }
        }

        return true;
    }
}
