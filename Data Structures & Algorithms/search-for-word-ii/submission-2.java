class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    String word;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
        this.word = "";
    }

    public void insert(String word) {
        TrieNode curr = this;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }

            curr = curr.children.get(c);
        }

        curr.isEnd = true;
        curr.word = word;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode node = new TrieNode();

        for (String word : words) {
            node.insert(word);
        }

        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, node, ans, visited);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode trieNode, List<String> ans, boolean[][] visited) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1 || visited[i][j]) {
            return;
        }

        char curr = board[i][j];

        if (!trieNode.children.containsKey(curr)) {
            return;
        }

        trieNode = trieNode.children.get(curr);

        if (trieNode.isEnd) {
            ans.add(trieNode.word);
            trieNode.isEnd = false;
        }

        visited[i][j] = true;

        dfs(board, i+1, j, trieNode, ans, visited);
        dfs(board, i-1, j, trieNode, ans, visited);
        dfs(board, i, j+1, trieNode, ans, visited);
        dfs(board, i, j-1, trieNode, ans, visited);

        visited[i][j] = false;
    }
}
