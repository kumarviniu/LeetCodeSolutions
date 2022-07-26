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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = height(root);
        return lca(root, 0, maxDepth);
    }
    
    public TreeNode lca(TreeNode root, int depth, int maxDepth) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            if (depth == maxDepth)
                return root;
            return null;
        }
        TreeNode l = lca(root.left, depth + 1, maxDepth);
        TreeNode r = lca(root.right, depth + 1, maxDepth);
        if (l != null && r != null)
            return root;
        return l != null ? l : r;
    }
    
    public int height(TreeNode root) {
        if (root == null)
            return -1;
        int l = 1 + height(root.left);
        int r = 1 + height(root.right);
        return Math.max(l, r);
    }
}