private class Node {
    Node[] children = new Node[26];
    boolean isWord;
}


private class Trie {
    Node root;
    Trie(String[] dictionary) {
        root = new Node();
        for (String s: dictionary) {
            Node curr = root;
            for (char letter: s.toCharArray()) {
                int idx = letter - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.isWord = true;
        }
    }
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie(dictionary);
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return visit(0, memo, trie.root, s);
    }

    private int visit(int i, int[] memo, Node root, String s) {
        if (s.length() == i) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int res = 1 + visit(i + 1, memo, root, s);
        Node curr = root;
        for (int j = i; j < s.length(); j++) {
            if (curr.children[s.charAt(j) - 'a'] == null) {
                break;
            }
            curr = curr.children[s.charAt(j) - 'a'];
            if (curr.isWord) {
                res = Math.min(res, visit(j + 1, memo, root, s));
            }
            memo[i] = res;
        }

        return res;
    }
}