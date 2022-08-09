class Solution {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            String nString = String.valueOf(n);
            int newN = 0;
            for (int i = 0; i <nString.length(); i++) {
                int val = Character.getNumericValue(nString.charAt(i));
                newN += val * val;
            }
            set.add(n);
            n = newN;
        }
        return n == 1;
    }
}