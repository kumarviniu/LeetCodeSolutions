class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         if (nums.length < 4)
      return Collections.emptyList();
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
      List<Integer[]> triplets = threeNumberSum(nums, i + 1, target - nums[i]);
      if (!triplets.isEmpty()) {
        for (Integer[] triplet : triplets) {
          Integer[] quadruplet = {nums[i], triplet[0], triplet[1], triplet[2]};
          result.add(Arrays.asList(quadruplet));
        } 
      }
    }
    return result;
    }
    
    
  public static List<Integer[]> threeNumberSum(int[] array, int start, long targetSum) {
      System.out.println(targetSum);
    List<Integer[]> result = new ArrayList<>();
    for (int i = start; i < array.length; i++) {
      List<Integer[]> pairs = twoSum(array, i + 1, targetSum - array[i]);
      if (!pairs.isEmpty()) {
        for (Integer[] pair : pairs) {
          Integer[] triplet = {array[i], pair[0], pair[1]};
          result.add(triplet);
        } 
      }
        int k = i + 1;
        while (k < array.length && array[k] == array[k - 1])
            k++;
        i = k - 1;
    }
    return result;
  }

  public static List<Integer[]> twoSum(int[] array, int start, long targetSum) {
    int i = start;
    int j = array.length - 1;
    List<Integer[]> result = new ArrayList<>();
    while (i < j) {
      int sum = array[i] + array[j];
      if (sum == targetSum) {
        Integer[] pair = {array[i], array[j]};
        result.add(pair);
         
        i++;
        while (i < j && array[i] == array[i - 1])
            i++;
        j--;
      } else if (sum < targetSum) {
        i++;
      } else {
        j--;
      }
    }
    return result;
  }
}