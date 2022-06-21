class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> dp = new HashMap<>();
        TrieNode root = new TrieNode();
        for (String word: wordDict)
            add(word, root);
        return dfs(s, 0, root, dp);
    }
    
    public void add(String word, TrieNode root) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode next = root.map.get(c);
            if (next == null) {
                TrieNode node = new TrieNode();
                root.map.put(c, node);
                next = node;
            }
            root = next;
        }
        root.end = true;
    }
    
    public boolean dfs(String s, int index, TrieNode root, Map<Integer, Boolean> dp) {
       if (index == s.length())
           return true;
        
        if (dp.containsKey(index))
            return dp.get(index);
        
        TrieNode curr = root;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if  (!curr.map.containsKey(c))
                break;
            if (curr.map.get(c).end) {
                boolean result = dfs(s, i + 1, root, dp);
                dp.put(index, result);
                if (result)
                    return true;
            }
            curr = curr.map.get(c);
        }
        dp.put(index, false);
        return false;
    }
    
    public static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean end = false;
    }
}