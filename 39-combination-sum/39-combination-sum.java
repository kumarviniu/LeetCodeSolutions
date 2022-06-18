class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result); 
        return result;
    }
    
    public void backtrack(int[] candidates, int i, int target, List<Integer> candidate, List<List<Integer>> result) {
        if (i >= candidates.length || target < 0)
            return;
        
        if (target == 0) {
            result.add(new ArrayList<>(candidate));
            return;
        }
        
        candidate.add(candidates[i]);
        backtrack(candidates, i, target - candidates[i], candidate, result);
        candidate.remove(candidate.size() - 1);
        backtrack(candidates, i + 1, target, candidate, result);        
    }
}