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
    public int maxDepth(TreeNode root) {
        int[] max = new int[1];
        maxDepth(root, 0, max);
        return max[0];
    }
    
    public void maxDepth(TreeNode root, int depth, int[] maxDepth) {
        if (root == null) {
            maxDepth[0] = Math.max(depth, maxDepth[0]);
            return;
        }
        maxDepth(root.left, depth + 1, maxDepth);
        maxDepth(root.right, depth + 1, maxDepth);
    }
}