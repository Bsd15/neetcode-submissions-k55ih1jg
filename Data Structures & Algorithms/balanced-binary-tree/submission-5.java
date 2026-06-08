/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isTreeBalanced(root)[0] == 1;
    }

    /**
     * @return int array of size 2.
     *   - result[0] - is balanced or not. will only contain 0 or 1
     *   - result[1] - is the height of the tree for the given node
     */
    private int[] isTreeBalanced(TreeNode node) {
        if (node == null) {
            return new int[] {1, 0};
        }
        int[] left = isTreeBalanced(node.left);
        int[] right = isTreeBalanced(node.right);

        boolean isBalanced = (left[0] == 1 && right[0] == 1) && (Math.abs(left[1] - right[1]) <= 1);
        return new int[] {isBalanced ? 1 : 0, 1 + Math.max(left[1], right[1])};
    }
}
