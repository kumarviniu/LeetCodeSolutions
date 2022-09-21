class Solution {
    public String frequencySort(String s) {
        int[][] freq = new int[123][2];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)][1]++;
            freq[s.charAt(i)][0] = s.charAt(i); 
        }
        Arrays.sort(freq, (a, b) -> Integer.compare(a[1], b[1]));
        StringBuilder sb = new StringBuilder("");
        for (int i = 122; i >= 0; i--) {
            int j = 0;
            while (j++ < freq[i][1])
                sb.append((char) freq[i][0]);
        }
        return sb.toString();
    }
}