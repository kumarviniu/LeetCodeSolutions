class Solution {
    public int numDecodings(String s) {
        int a = 1;
        int b = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int result = 0;
            if (s.charAt(i) != '0') {
                result = a;
            }
            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'))) {
                result += b;
            }
            
            b = a;
            a = result;
        }
        return a;
    }
}