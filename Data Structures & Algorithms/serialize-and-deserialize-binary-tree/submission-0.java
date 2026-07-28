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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            var curr = queue.removeFirst();
            if (curr == null) {
                stringBuilder.append("n");
            } else {
                stringBuilder.append(curr.val);
                queue.addLast(curr.left);
                queue.addLast(curr.right);
            }
            stringBuilder.append(",");
        }

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodeArray = data.split(",");
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(nodeArray[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (i < nodeArray.length) {
            TreeNode curr = queue.removeFirst();
            String val = nodeArray[i++];
            if (!val.equals("n")) {
                TreeNode node = new TreeNode(Integer.parseInt(val));
                curr.left = node;
                queue.addLast(node);
            }

            val = nodeArray[i++];
            if (!val.equals("n")) {
                TreeNode node = new TreeNode(Integer.parseInt(val));
                curr.right = node;
                queue.addLast(node);
            }
        }
        return root;
    }
}
