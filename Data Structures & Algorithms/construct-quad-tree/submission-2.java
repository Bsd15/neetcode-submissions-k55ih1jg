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
        return divide(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    private Node divide(int[][] grid, int r1, int r2, int c1, int c2) {
        if (r1 == r2 && c1 == c2) {
            return new Node(grid[r1][c1] == 1, true);
        } else {
            int rMid = (r1 + r2)/2;
            int cMid = (c1 + c2)/2;
            Node n1 = divide(grid, r1, rMid, c1, cMid);
            Node n2 = divide(grid, r1, rMid, cMid + 1, c2);
            Node n3 = divide(grid, rMid + 1, r2, c1, cMid);
            Node n4 = divide(grid, rMid + 1, r2, cMid + 1, c2);
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