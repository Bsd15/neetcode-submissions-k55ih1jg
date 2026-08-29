class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;

        Node root = new Node();
        for (String word : words) {
            var curr = root;
            for (char l : word.toCharArray()) {
                curr = curr.children.computeIfAbsent(l, k -> new Node());
            }
            curr.isWord = true;
        }

        List<String> result = new ArrayList<>();
        boolean[][] marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visit(board, i, j, root, rows, cols, new StringBuilder(), result, marked);
            }
        }
        return result;
    }

    private void visit(char[][] board, int i, int j, Node node, int rows, int cols,
        StringBuilder currRes, List<String> result, boolean[][] marked) {
        if (marked[i][j]) {
            return;
        }

        if (!node.children.containsKey(board[i][j])) {
            return;
        }

        node = node.children.get(board[i][j]);
        currRes.append(board[i][j]);
        marked[i][j] = true;

        if (node.isWord) {
            result.add(currRes.toString());
            node.isWord = false;
        }

        if (i > 0) {
            visit(board, i - 1, j, node, rows, cols, currRes, result, marked);
        }

        if (i < rows - 1) {
            visit(board, i + 1, j, node, rows, cols, currRes, result, marked);
        }

        if (j > 0) {
            visit(board, i, j - 1, node, rows, cols, currRes, result, marked);
        }

        if (j < cols - 1) {
            visit(board, i, j + 1, node, rows, cols, currRes, result, marked);
        }

        marked[i][j] = false;
        currRes.deleteCharAt(currRes.length() - 1);
    }

    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;
    }
}
