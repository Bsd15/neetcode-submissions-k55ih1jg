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
    public List<Integer> preorderTraversal(TreeNode root) {
        var stack = new ArrayDeque<TreeNode>();
        var curr = root;
        List<Integer> result = new ArrayList<>();
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                result.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                var top = stack.pop();
                curr = top.right;
            }
        }

        return result;
    }
}