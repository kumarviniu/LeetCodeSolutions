class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> countPair = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (countPair.isEmpty() || s.charAt(i) != countPair.peek().c)
                countPair.add(new Pair(s.charAt(i), 1));
            else {
                if (++countPair.peek().count == k)
                    countPair.pop();
            }
        }
        StringBuilder sb = new StringBuilder(countPair.size());
        while (!countPair.isEmpty()) {
            Pair topPair = countPair.pop();
            while (topPair.count-- > 0)
                sb.append(topPair.c);
        }
        return sb.reverse().toString();
    }
    
    static class Pair {
        char c;
        int count;
        Pair(char c, int i) {
            this.c = c;
            this.count = i;
        }
    }
}

