class Solution {
   
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightMost = rightMost(curr.left);
                rightMost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    
    public TreeNode rightMost(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }
}