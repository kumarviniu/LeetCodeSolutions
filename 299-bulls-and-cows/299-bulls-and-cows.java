class Solution {
    public String getHint(String secret, String guess) {

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
 
        int cows = 0;
        int bulls = 0;
        
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                if (freq.get(guess.charAt(i)) == 0) {
                    bulls--;
                    cows++;
                } else {
                    cows++;
                    freq.put(guess.charAt(i), freq.get(guess.charAt(i)) - 1);
                }
            } else if (freq.containsKey(guess.charAt(i)) && freq.get(guess.charAt(i)) > 0) {
                bulls++;
                freq.put(guess.charAt(i), freq.get(guess.charAt(i)) - 1);   
            }
        }
        return cows + "A" + bulls + "B";
    }
}