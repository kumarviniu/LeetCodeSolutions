class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder left = new StringBuilder(s.length());
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') left.append(c);
            else if (c == '(') {
                open++;
                left.append(c);
            }
            else if (open > 0) {
                open--;
                left.append(c);
            }
        }
        int close = 0;
        StringBuilder result = new StringBuilder(left.length());
        for (int i = left.length() - 1; i >= 0; i--) {
            char c = left.charAt(i);
            if (c >= 'a' && c <= 'z') result.append(c);
             else if (c == ')') {
                close++;
                result.append(c);
            }
            else if (close > 0) {
                close--;
                result.append(c);
            }
        }
        
        return result.reverse().toString();
    }
}