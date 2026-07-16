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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var dummy = new TreeNode();
        var curr = dummy;
        int i = 0, j = 0, n = preorder.length;
        while (i < n && j < n) {
            curr.right = new TreeNode(preorder[i++], null, curr.right);
            curr = curr.right;
            while (i < n && curr.val != inorder[j]) {
                curr.left = new TreeNode(preorder[i++], null, curr);
                curr = curr.left;
            }
            j++;

            while (curr.right != null && j < n && curr.right.val == inorder[j]) {
                var prev = curr.right;
                curr.right = null;
                curr = prev;
                j++;
            }
        }
        return dummy.right;
    }
}
