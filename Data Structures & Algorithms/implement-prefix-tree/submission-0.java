class PrefixTree {
    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = this.root;
        for (char letter : word.toCharArray()) {
            curr = curr.setChild(letter);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = this.root;
        for (char letter : word.toCharArray()) {
            curr = curr.getChild(letter);
            if (curr == null) {
                return false;
            }
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = this.root;
        for (char letter : prefix.toCharArray()) {
            curr = curr.getChild(letter);
            if (curr == null) {
                return false;
            }
        }

        return true;
    }

    private class Node {
        boolean isWord = false;
        Node[] children = new Node[26];

        Node getChild(char letter) {
            return this.children[letter - 'a'];
        }

        Node setChild(char letter) {
            int index = letter - 'a';
            if (this.children[index] == null) {
                this.children[letter - 'a'] = new Node();
            }
            return this.children[index];
        }

        boolean isEmpty() {
            for (int i = 0; i < 26; i++) {
                if (this.children[i] != null) {
                    return false;
                }
            }
            return true;
        }
    }
}
