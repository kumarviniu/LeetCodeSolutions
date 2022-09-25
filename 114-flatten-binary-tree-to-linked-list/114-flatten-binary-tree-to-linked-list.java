class Solution {
   
    public void flatten(TreeNode root) {
        flattenRecursively(root);
    }
    
    public TreeNode flattenRecursively(TreeNode node) {
        if (node == null) return null;
        TreeNode leftTail = flattenRecursively(node.left);
        TreeNode rightTail = flattenRecursively(node.right);
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightTail == null ? leftTail == null ? node : leftTail : rightTail;
    }
}