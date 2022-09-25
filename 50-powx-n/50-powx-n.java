class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || x == 0) return x;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }
        return pow(x, N);
    }
    
    public double pow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) {
            double left = pow(x, n / 2);
            return left * left;
        }
        return pow(x, n - 1) * x;
    }
}