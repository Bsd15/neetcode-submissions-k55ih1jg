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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currP = root;
        TreeNode currQ = root;
        TreeNode prev = null;
        while (currP != null && currQ != null) {
            prev = currP;
            if (currP.val == p.val) {
                return currP;
            }
            if (currQ.val == q.val) {
                return currQ;
            }
            currP = search(currP, p);
            currQ = search(currQ, q);
            if (currP != currQ) {
                return prev;
            }
        }
        return null;
    }

    private TreeNode search(TreeNode node, TreeNode p) {
        if (node == null) {
            return null;
        }

        if (node.val == p.val) {
            return node;
        } else if (node.val > p.val) {
            return node.left;
        } else {
            return node.right;
        }
    }
}
