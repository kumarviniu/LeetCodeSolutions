class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sFreq.put(s.charAt(i), sFreq.getOrDefault(s.charAt(i), 0) + 1);
            tFreq.put(t.charAt(i), tFreq.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int minSteps = 0;
        for (Character sKey : sFreq.keySet())
            minSteps += sFreq.get(sKey) - Math.min(sFreq.get(sKey), tFreq.getOrDefault(sKey, 0));
        
        return minSteps;
    }
}