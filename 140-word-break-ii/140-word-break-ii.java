class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> dp = new HashMap<>();
        Set<String> words = new HashSet<>();
        for (String word : wordDict)
            words.add(word);
        return dfs(s, words, dp);
    }
    
    public List<String> dfs(String s, Set<String> words, Map<String, List<String>> dp) {
        if (s.isEmpty())
            return Collections.singletonList("");
        if (dp.containsKey(s))
            return dp.get(s);
        
        for (String word: words) {
            if (s.startsWith(word)) {
                String sub = s.substring(0, word.length());
                List<String> out = dfs(s.substring(word.length(), s.length()), words, dp);
                List<String> result = dp.getOrDefault(s, new ArrayList<>());
                for (String o : out) {
                    result.add(sub + (o.isEmpty() ? "" : " " + o));
                }
                dp.put(s, result);
            }
        }
        if (!dp.containsKey(s))
            dp.put(s, new ArrayList<>());
        return dp.get(s);
    }
}