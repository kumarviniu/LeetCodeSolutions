/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> colListMap = new TreeMap<>();
        dfs(root, 0, 0, colListMap);
        List<List<Integer>> result = new ArrayList<>();
        for (Integer col : colListMap.keySet()) {
            List<Integer> colValues = new ArrayList<>();
            for (List<Integer> rowList : colListMap.get(col).values()) {
                Collections.sort(rowList);
                colValues.addAll(rowList);
            }
            result.add(colValues);
        }
        return result;
    }
    
    public void dfs(TreeNode root, int col, int row, Map<Integer, Map<Integer, List<Integer>>> colListMap) {
        if (root == null) return;
        Map<Integer, List<Integer>> rowMap = colListMap.getOrDefault(col, new TreeMap<>());
        List<Integer> nodes = rowMap.getOrDefault(row, new ArrayList<>());
        nodes.add(root.val);
        rowMap.putIfAbsent(row, nodes);
        colListMap.putIfAbsent(col, rowMap);
        dfs(root.left, col - 1, row + 1, colListMap);
        dfs(root.right, col + 1, row + 1, colListMap);
    }
}