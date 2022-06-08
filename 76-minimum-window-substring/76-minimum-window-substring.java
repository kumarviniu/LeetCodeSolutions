class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        
        int l = 0;
        int r = t.length() - 1;
        
        Map<Character, Integer> smap = new HashMap<>();
        for(int i = 0; i < t.length(); i++)
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        
        int min = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        
        while (r < s.length()) {
            if (isMatch(tmap, smap)) {
                if ((r - l + 1) < min) {
                    min = r - l + 1;
                    minL = l;
                    minR = r;
                    if (min == t.length()) break;
                }
                smap.put(s.charAt(l), smap.get(s.charAt(l)) - 1);
                l++;
            } else {
                r++;
                if (r < s.length())
                    smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);
            }
        }
        
        return min != Integer.MAX_VALUE ? s.substring(minL, minR + 1) : "";
    }
    
    public boolean isMatch(Map<Character, Integer> tmap, Map<Character, Integer> smap) {
        for (Character key : tmap.keySet()) {
            Integer val = tmap.get(key);
            if (!smap.containsKey(key) || smap.get(key) < val) return false;
        }
        return true;
    }
}