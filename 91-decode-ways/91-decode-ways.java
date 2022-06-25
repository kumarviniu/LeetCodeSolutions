class Solution {
    public int numDecodings(String s) {
        return dfs(s, 0, new HashMap<>());
    }
    
    public int dfs(String s, int index, Map<Integer, Integer> map) {
        if (index == s.length())
            return 1;
        
        if (s.charAt(index) == '0')
            return 0;
        
        if (map.containsKey(index))
            return map.get(index);
        
        int result = dfs(s, index + 1, map);
        
        if (index + 1 < s.length()
            && (s.charAt(index) == '1' 
                || (s.charAt(index) == '2' && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '6')))
            result += dfs(s, index + 2, map);
        
        map.put(index, result);
        
        return result;
    }
}