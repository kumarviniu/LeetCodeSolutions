class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.contains(c)) {
                TrieNode node = new TrieNode();
                curr.put(c, node);
            }
            curr = curr.next(c);
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        int i;
        for(i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.contains(c))
                return false;
            curr = curr.next(c);
        }
        
        return curr.end && i == word.length();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int i;
        for(i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.contains(c))
                return false;
            curr = curr.next(c);
        }
        return i == prefix.length();
    }
    
    static class TrieNode {
        Map<Character, TrieNode> suffix = new HashMap<>();
        boolean end = false;
        
        boolean contains(Character c) {
            return suffix.get(c) != null;
        }
        
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