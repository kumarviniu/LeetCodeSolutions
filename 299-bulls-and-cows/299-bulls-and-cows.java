class Solution {
    public String getHint(String secret, String guess) {
        
        Map<Character, Set<Integer>> characterIndexSetMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            Set<Integer> indexSet = characterIndexSetMap.getOrDefault(c, new HashSet<>());
            indexSet.add(i);
            characterIndexSetMap.put(c, indexSet);
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                char c = secret.charAt(i);
                freqMap.put(c, freqMap.get(c) - 1);
                cows++;
            }
        }
        
        int bulls = 0;
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            Set<Integer> inputCharIndex = characterIndexSetMap.get(c);
            if (secret.charAt(i) == guess.charAt(i))
                continue;
            if (inputCharIndex != null && freqMap.get(c) > 0) {
                bulls++;
            }
            
            freqMap.put(c, freqMap.getOrDefault(c, 0) - 1);
        }
        return cows + "A" + bulls + "B";
    }
}