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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        dfsLevelOrder(root, 0, result);
        return result;
    }
    
    public void dfsLevelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (level == result.size())
            result.add(new LinkedList<>());
        result.get(level).add(root.val);
        dfsLevelOrder(root.left, level + 1, result);
        dfsLevelOrder(root.right, level + 1, result);
    }
}