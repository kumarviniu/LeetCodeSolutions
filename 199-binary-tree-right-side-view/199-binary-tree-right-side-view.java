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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        right(root, 0, new HashSet<>(), result);
        return result;
    }
    
    public void right(TreeNode root, int depth, Set<Integer> depths, List<Integer> result) {
        if (root == null)
            return;
        if (!depths.contains(depth)) {
            result.add(root.val);
            depths.add(depth);
        }
        right(root.right, depth + 1, depths, result);
        right(root.left, depth + 1, depths, result);
    }
}