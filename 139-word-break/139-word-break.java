class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> dp = new HashMap<>();
        Set<String> words = new HashSet<>();
        for (String word : wordDict)
            words.add(word);
        return dfs(s, words, dp);
    }
    
    public boolean dfs(String s, Set<String> words, Map<String, Boolean> dp) {
        if (s.isEmpty())
            return true;
        if (dp.containsKey(s))
            return dp.get(s);
        
        for (String word : words) {
            if (s.startsWith(word)) {
                boolean result = dfs(s.substring(word.length(), s.length()), words, dp);
                dp.put(s, result);
                if (result)
                    return true;
            }
        }
        return false;
    }
}