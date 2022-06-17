class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = curr.next(word.charAt(i));
            if (next == null) {
                TrieNode node = new TrieNode();
                curr.put(word.charAt(i), node);
                next = node;
            }
            curr = next;
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        return match(word, true);
    }
    
    public boolean startsWith(String prefix) {
        return match(prefix, false);
    }
    
    public boolean match(String word, boolean checkEnd) {
        TrieNode curr = root;
        int i;
        for(i = 0; i < word.length(); i++) {
            TrieNode next = curr.next(word.charAt(i));
            if (next == null)
                return false;
            curr = next;
        }
        return checkEnd ? curr.end : true;
    }
    
    static class TrieNode {
        Map<Character, TrieNode> suffix = new HashMap<>();
        boolean end = false;
        
        TrieNode next(Character c) {
            return suffix.get(c);
        }
        
        void put(Character c, TrieNode node) {
            suffix.put(c, node);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */