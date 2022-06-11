/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = new ArrayList<>();
        List<TreeNode> ql = new ArrayList<>();
        preorder(root, p, pl);
        preorder(root, q, ql);
        pl.retainAll(ql);
        return pl.get(pl.size() - 1);
    }
    
    public boolean preorder(TreeNode root, TreeNode f, List<TreeNode> list) {
        if (root == null)
            return false;
        list.add(root);
        if (root.val == f.val)
            return true;
        boolean result = preorder(root.left, f, list);
        result = result || preorder(root.right, f, list);
        if (!result && !list.isEmpty())
            list.remove(list.size() - 1);
        return result;
    }
}