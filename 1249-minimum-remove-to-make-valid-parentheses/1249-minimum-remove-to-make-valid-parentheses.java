class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();
        Set<Integer> removeIdxList = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') continue;
            if (c == '(') stack.add(new Pair(c, i));
            else if (stack.isEmpty())
                removeIdxList.add(i);
            else
                stack.pop();
        }
        while (!stack.isEmpty())
            removeIdxList.add(stack.pop().idx);
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (removeIdxList.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    static class Pair {
        char c;
        int idx;
        
        Pair(char c, int i) {
            this.c = c;
            idx = i;
        }
    }
}