import java.math.BigInteger;
class Solution {
    public int uniquePaths(int m, int n) {
        m = m - 1;
        n = n - 1;
        return factorial(m + n, m + 1).divide(factorial(n, 1)).intValue();
    }
    BigInteger factorial(int n, int r) {
        n = r > n ? 1 : n;
        BigInteger b = new BigInteger(String.valueOf(Math.max(1, n)));
        while(n-- > r)
            b = b.multiply(new BigInteger(String.valueOf(n)));
        return b;
    }
}