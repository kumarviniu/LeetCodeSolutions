class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        
        int l = 0;
        int r = 0;

        int min = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        
        for (int i = 0; i < t.length(); i++)
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        
        int need = tmap.size();
        int have = 0;
        
        while (r < s.length()) {
            char c = s.charAt(r);
            if (tmap.containsKey(c)) {
                int val = smap.getOrDefault(c, 0);
                smap.put(c, val + 1);
                if (val + 1 == tmap.get(c))
                    have++;
                while (have == need) {
                    if (r - l + 1 < min) {
                        min = r - l + 1;
                        minL = l;
                        minR = r;
                    }   
                    c = s.charAt(l);
                    if (tmap.containsKey(c)) {
                        if (smap.get(c) - 1 < tmap.get(c))
                            have--;
                        smap.put(c, smap.get(c) - 1);
                    }
                    l++;
                }
            }
            r++;
        }
        
        return min != Integer.MAX_VALUE ? s.substring(minL, minR + 1) : "";
    }
}