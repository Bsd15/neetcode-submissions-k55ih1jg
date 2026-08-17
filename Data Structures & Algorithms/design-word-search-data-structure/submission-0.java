class WordDictionary {
    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node curr = this.root;
        for (char letter : word.toCharArray()) {
            curr = curr.setChild(letter);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, Node node, int depth) {
        if (word.length() == depth) {
            if (node == null)
                return false;
            
            if (!node.isWord)
                return false;
            
            return true;
        }

        char letter = word.charAt(depth);
        if (letter == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    boolean isFound = search(word, node.children[i], depth + 1);
                    if (isFound) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            Node child = node.getChild(letter);
            if (child == null) {
                return false;
            }
            return search(word, child, depth + 1);
        }
    }

    private static class Node {
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

        void deleteChild(char letter) {
            int index = letter - 'a';
            this.children[index] = null;
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
