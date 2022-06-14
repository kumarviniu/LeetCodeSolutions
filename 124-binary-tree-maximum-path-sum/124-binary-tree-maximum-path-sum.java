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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {root.val};
        maxPathSum(root, max);
        return max[0];
    }
    
    public int maxPathSum(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        max[0] = Math.max(max[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }
}