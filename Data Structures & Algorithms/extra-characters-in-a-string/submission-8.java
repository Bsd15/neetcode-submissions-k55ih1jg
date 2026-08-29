class Solution {
    Node root;
    {
        this.root = new Node();
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        
        for (String word: dictionary) {
            Node curr = this.root;
            for (char letter: word.toCharArray()) {
                int i = letter - 'a';
                if (curr.children[i] == null) {
                    curr.children[i] = new Node();
                }
                curr = curr.children[i];
            }
            curr.isWord = true;
        }

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 0);

        return dfs(s, 0, dp);
    }

    private int dfs(String s, int i, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        int res = 1 + dfs(s, i + 1, dp);
        Node curr = this.root;
        for (int j = i; j < s.length(); j++) {
            if (curr.children[s.charAt(j) - 'a'] == null) {
                break;
            }

            curr = curr.children[s.charAt(j) - 'a'];
            if (curr.isWord) {
                res = Math.min(res, dfs(s, j + 1, dp));
            }

            dp.put(i, res);
        }

        return res;
    }

    private static class Node {
        Node[] children = new Node[26];
        boolean isWord;
    }
}