class Solution {
    public String decodeString(String s) {
        return decode(s, 0).string;
    }
    
    public Pair decode(String s, int i) {
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isLetter(c))
                sb.append(c);
            else if (Character.isDigit(c))
                count = count * 10 + Character.getNumericValue(c);
            else if (c == ']')
                break;
            else if (c == '[') {
                Pair pair = decode(s, i + 1);
                
                while (count > 0) {
                    sb.append(pair.string);
                    count--;
                }
                i = pair.idx;
            }
            i++;
        }
        return new Pair(sb.toString(), i);
    }
    
    public static class Pair {
        String string;
        int idx;
        Pair(String s, int i) {
            string = s;
            idx = i;
        }
    }
}