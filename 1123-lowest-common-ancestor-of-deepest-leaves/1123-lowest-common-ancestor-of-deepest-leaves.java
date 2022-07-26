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
        return lca(root, 0).node;
    }
    
    public Result lca(TreeNode root, int depth) {
        if (root == null || (root.left == null && root.right == null))
            return new Result(root, depth);
        
        Result l = lca(root.left, depth + 1);
        Result r = lca(root.right, depth + 1);
        
        if (l.node != null && r.node != null) {
            if (l.depth > r.depth)
                return l;
            else if (r.depth > l.depth)
                return r;
            else
                return new Result(root, Math.max(l.depth, r.depth));
        }
        return l.node != null ? l : r;
    }
    
    public static class Result {
        public TreeNode node;
        public int depth;
        public Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}