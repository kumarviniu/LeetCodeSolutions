class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        
        char[] s1FreqArray = new char[26];
        char[] s2WindowFreqArray = new char[26];
        
        
        int s1Size = s1.length();
        int have = 0;
        int required = s1Size;
        int start = 1 - s1Size;
        
        for (int i = 0; i < s1.length(); i++) {
            int charIdx = s1.charAt(i) - 97;
            s1FreqArray[charIdx]++;
        }
     
        for (int i = 0; i < s2.length(); i++) {
            int charIdx = s2.charAt(i) - 97;
            s2WindowFreqArray[charIdx]++;
            if (s2WindowFreqArray[charIdx] <= s1FreqArray[charIdx]) have++;
            if (start >= 0) {
                if (have == required) return true;
                int startCharIdx = s2.charAt(start) - 97;
                s2WindowFreqArray[startCharIdx]--;
                if (s2WindowFreqArray[startCharIdx] < s1FreqArray[startCharIdx]) have--;
            }
            start++;
        }
        return false;
    }
}