/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return divide(grid, grid.length, 0, 0);
    }

    private Node divide(int[][] grid, int n, int r, int c) {
        if (n == 1) {
            return new Node(grid[r][c] == 1, true);
        } else {
            int mid = n/2;
            Node n1 = divide(grid, mid, r, c);
            Node n2 = divide(grid, mid, r, c + mid);
            Node n3 = divide(grid, mid, r + mid, c);
            Node n4 = divide(grid, mid, r + mid, c + mid);
            boolean areAllLeafNodes = n1.isLeaf && n2.isLeaf && n3.isLeaf && n4.isLeaf;
            boolean areAllLeafNodesEqualVal = n1.val == n2.val && n2.val == n3.val && n3.val == n4.val;
            if (areAllLeafNodes && areAllLeafNodesEqualVal) {
                return n1;
            } else {
                return new Node(true, false, n1, n2, n3, n4);
            }
        }
    }
}