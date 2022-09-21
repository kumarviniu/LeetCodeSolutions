class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0;
        int sum = 0;
        int total = 0;
        int n = arr.length;
        while (i < n && total < target) {
            sum += arr[i];
            total = sum;
            total += arr[i] * (n - i - 1);
            i++;
        }
        
        if (i == n || total == target) return arr[i - 1];
        i--;
        sum -= arr[i];
        int start = i == 0 ? 0 : arr[i - 1];
        int end = arr[i];
        int remaining = n - i;
        int diff = Integer.MAX_VALUE;
        while (start <= end) {
            total = sum + start * remaining;
            if (Math.abs(target - total) < diff) {
                diff = Math.abs(target - total);
            } else 
                break;
            start++;
        }
        return start - 1;
        
    }
}