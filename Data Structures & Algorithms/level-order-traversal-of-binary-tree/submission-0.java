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
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        visit(root, result, 0);
        return result;
    }

    private void visit(TreeNode node, List<List<Integer>> result, int treeLevel) {
        if (node == null) {
            return;
        }

        if (result.size() <= treeLevel) {
            result.add(new ArrayList<>());
        }

        result.get(treeLevel).add(node.val);

        visit(node.left, result, treeLevel + 1);
        visit(node.right, result, treeLevel + 1);
    } 
}
