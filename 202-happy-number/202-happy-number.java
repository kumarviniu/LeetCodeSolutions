class Solution {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        
        int newN = getNewN(n);
        
        while (newN != 1 && n != newN) {
            n = getNewN(n);
            newN = getNewN(getNewN(newN));
        }
        return newN == 1;
    }
    
    public int getNewN(int n) {
        int newN = 0;
        while (n != 0) {
            int mod = n % 10;
            newN += mod * mod;
            n /= 10;
        }
        return newN;
    }
}