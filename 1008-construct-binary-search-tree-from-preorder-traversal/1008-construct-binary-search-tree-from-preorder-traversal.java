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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int leftEnd = getLeftEnd(preorder, start, end);
        root.left = bstFromPreorder(preorder, start + 1, leftEnd);
        root.right = bstFromPreorder(preorder, leftEnd + 1, end);
        return root;
    }
    
    public int getLeftEnd(int[] preorder, int start, int end) {
        int i = start + 1;
        while (i <= end && preorder[i] < preorder[start])
            i++;
        return i - 1;
    }
}