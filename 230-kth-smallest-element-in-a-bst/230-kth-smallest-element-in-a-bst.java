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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        return inOrder(root, k, count);
    }
    
    public int inOrder(TreeNode root, int k, int[] count) {
        if (root == null)
            return -1;
        int result = inOrder(root.left, k, count);
        if (result != -1)
            return result;
        if (++count[0] == k)
            return root.val;
        return inOrder(root.right, k, count);
    }
}