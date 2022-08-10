class Solution {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        
        int newN = getNewN(String.valueOf(n));
        
        while (newN != 1 && n != newN) {
            n = getNewN(String.valueOf(n));
            newN = getNewN(String.valueOf(getNewN(String.valueOf(newN))));
        }
        return newN == 1;
    }
    
    public int getNewN(String nString) {
        int newN = 0;
        for (int i = 0; i <nString.length(); i++) {
            int val = Character.getNumericValue(nString.charAt(i));
            newN += val * val;
        }
        return newN;
    }
}