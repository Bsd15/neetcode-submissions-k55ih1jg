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
    private TreeNode root;
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        this.root = root;
        TreeNode curr = root;
        TreeNode parent = null;
        while (curr != null) {
            if (curr.val == key) {
                deleteNode(parent, curr);
                break;
            } else if (curr.val > key) {
                parent = curr;
                curr = curr.left;
            } else {
                parent = curr;
                curr = curr.right;
            }
        }
        return this.root;
    }

    /**
     * Need this method to verify result not used in the main code
     * @param node node from which we need to start the search
     * @param key value to search
     * @return Array of parent node and the node with the given key
     */
    public TreeNode search(TreeNode node, int key) {
        TreeNode curr = node;
        while (curr != null) {
            if (curr.val == key) {
                return curr;
            } else if (curr.val > key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }

    private void deleteNode(TreeNode parent, TreeNode nodeToDel) {
        if (nodeToDel.left == null) {
            transplant(parent, nodeToDel, nodeToDel.right);
        } else if (nodeToDel.right == null) {
            transplant(parent, nodeToDel, nodeToDel.left);
        } else {
            TreeNode[] treeMinimumRes = treeMinimum(nodeToDel.right);
            TreeNode parentOfNodeToReplace = treeMinimumRes[0];
            TreeNode nodeToReplace = treeMinimumRes[1];
            if (nodeToReplace != nodeToDel.right) {
                transplant(parentOfNodeToReplace, nodeToReplace, nodeToReplace.right);
                nodeToReplace.right = nodeToDel.right;
            }
            transplant(parent, nodeToDel, nodeToReplace);
            nodeToReplace.left = nodeToDel.left;
        }
    }

    private void transplant(TreeNode parent, TreeNode nodeToDel, TreeNode nodeToReplace) {
        if (parent == null) {
            this.root = nodeToReplace;
        } else if (nodeToDel == parent.left) {
            parent.left = nodeToReplace;
        } else {
            parent.right = nodeToReplace;
        }
    }

    private TreeNode[] treeMinimum(TreeNode node) {
        if (node == null) {
            return new TreeNode[] {null, null};
        }
        TreeNode parent = null;
        TreeNode curr = node;
        while (curr.left != null) {
            parent = curr;
            curr = curr.left;
        }
        return new TreeNode[] {parent, curr};
    }
}