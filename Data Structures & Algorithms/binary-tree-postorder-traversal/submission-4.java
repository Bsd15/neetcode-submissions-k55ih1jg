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
    public List<Integer> postorderTraversal(TreeNode root) {
        var stack = new ArrayDeque<TreeNode>();
        var result = new ArrayList<Integer>();
        var curr = root;
        TreeNode lastVisited = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode top = stack.peek();
                if (top.right != null && top.right != lastVisited) {
                    curr = top.right;
                } else {
                    stack.pop();
                    result.add(top.val);
                    lastVisited = top;
                }
            }
        }
        return result;
    }
}