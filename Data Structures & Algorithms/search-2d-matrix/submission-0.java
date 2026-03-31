class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int n = r * c;

        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l)/2;
            int mRow = m / c;
            int mCol = m % c;
            if (matrix[mRow][mCol] == target) {
                return true;
            } else if (target < matrix[mRow][mCol]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
