class Solution {
    public int candy(int[] ratings) {
        int[] rewards = new int[ratings.length];
    Arrays.fill(rewards, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1])
        rewards[i] += rewards[i - 1];
    }

    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1])
        rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
    }

    int total = 0;
    for (int reward: rewards)
      total += reward;
    return total;
    }
}