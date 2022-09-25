class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || x == 0) return x;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }
        double ans = 1;
        double product = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1)
                ans *= product;
            product *= product;
        }
        return ans;
    }
}