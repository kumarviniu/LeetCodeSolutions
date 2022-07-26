class Solution {
    public List<String> printVertically(String s) {
        String[] split = s.split(" ");
        int idx = 0;
        int i = 0;
        boolean isValid = false;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        int lastChar = 0;
        while (true) {
            if (idx < split[i].length()) {
                sb.append(split[i].charAt(idx));
                isValid = true;
                lastChar = sb.length();
            } else
                sb.append(" ");
            if (i == split.length - 1) {
                if (!isValid) break;
                result.add(sb.substring(0, lastChar));
                sb = new StringBuilder("");
                isValid = false;
                idx++;
                lastChar = 0;
                i = -1;
            }
            i++;
        }
        return result;
    }
}