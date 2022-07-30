class Solution {
    public int candy(int[] ratings) {
        int lastMaxReward = 1;
        int lastMaxIndex = 0;
        int lastAllocatedReward = 1;
        int totalRewards = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                lastAllocatedReward++;
                lastMaxIndex = i;
                lastMaxReward = lastAllocatedReward;
                totalRewards += lastAllocatedReward;
            } else if (ratings[i] == ratings[i - 1]) {
                totalRewards++;
                lastAllocatedReward = 1;
                lastMaxReward = 1;
                lastMaxIndex = i;
            } else if (lastAllocatedReward > 1) {
                lastAllocatedReward = 1;
                totalRewards += lastAllocatedReward;
            } else {
                totalRewards += i - lastMaxIndex;
                if (i - lastMaxIndex >= lastMaxReward) totalRewards++;
            }
        }
        return totalRewards;
    }
}