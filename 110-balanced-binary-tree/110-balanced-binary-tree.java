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
    public boolean isBalanced(TreeNode root) {
        boolean[] isBalance = { true };
        heightDiff(root, isBalance);
        return isBalance[0];
    }
    
    public int heightDiff(TreeNode root, boolean[] isBalance) {
        if (root == null)
            return 0;
        int l = heightDiff(root.left, isBalance);
        int r = heightDiff(root.right, isBalance);
        if (Math.abs(l - r) > 1)
            isBalance[0] = false;
        return Math.max(l, r) + 1;
    }
}