class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (prefix.isEmpty())
                break;
            prefix = prefix(prefix, strs[i]);
        }
        return prefix;
    }
    
    public String prefix(String s1, String s2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder("");
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j))
                break;
            sb.append(s1.charAt(i));
            i++;
            j++;
        }
        return sb.toString();
    }
}