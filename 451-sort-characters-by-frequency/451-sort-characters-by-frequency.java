class Solution {
    public String frequencySort(String s) {
        int[][] charCount = new int[123][2];
        for (int i = 0; i < s.length(); i++) {
            int c = (int) s.charAt(i);
            charCount[c][0] = c;
            charCount[c][1]++;
        }
        Arrays.sort(charCount, (a, b) -> Integer.compare(b[1], a[1]));
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < charCount.length; i++) {
            while (charCount[i][1] > 0) {
                sb.append((char) charCount[i][0]);
                charCount[i][1]--;
            }
        }
        return sb.toString();
    }
}