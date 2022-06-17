class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node next = curr.map.get(c);
            if (next == null) {
                Node node = new Node();
                curr.map.put(c, node);
                next = node;
            }
            curr = next;
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int i, Node root) {
        if (i == word.length())
            return root.end;
        
        if (root.end && i > word.length())
            return false;
        
        char c = word.charAt(i);
        if (c != '.') {
            if (!root.map.containsKey(c))
                return false;
            return search(word, i + 1, root.map.get(c));
        }
        
        for (Character key : root.map.keySet()) {
            if (search(word, i + 1, root.map.get(key)))
                return true;
        }
        
        return false;
    }
    
    static class Node {
        Map<Character, Node> map = new HashMap<>();
        boolean end = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */