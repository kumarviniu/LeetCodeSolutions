class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        int next = 1;
        int offset = 0;
        for (int i = 1; i <= n; i++) {
            if (i == next) {
                offset = next;
                next *= 2;
            }
            result[i] = 1 + result[i - offset];
        }
        return result;
    }
}