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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode lastVisited = null;
        TreeNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            var top = stack.peek();
            if (top.right != null && top.right != lastVisited) {
                curr = top.right;
            } else {
                lastVisited = top;
                stack.pop();
                if (top.val == target && top.left == null && top.right == null) {
                    TreeNode parent = stack.peekFirst();
                    if (parent == null) {
                        return null;
                    } else {
                        if (parent.left == top) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                }
            }
        }
        return root;
    }
}