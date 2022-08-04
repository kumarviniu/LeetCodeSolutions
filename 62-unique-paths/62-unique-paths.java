import java.math.BigInteger;
class Solution {
    public int uniquePaths(int m, int n) {
        return factorial((m - 1) + (n - 1)).divide(factorial(m - 1).multiply(factorial(n - 1))).intValue();
    }
    BigInteger factorial(int n) {
        BigInteger b = new BigInteger(String.valueOf(Math.max(1, n)));
        while(n-- > 1)
            b = b.multiply(new BigInteger(String.valueOf(n)));
        return b;
    }
}