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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> out = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size - 1; i++) {
                TreeNode s = q.poll();
                if (s.left != null)
                    q.add(s.left);
                if (s.right != null)
                    q.add(s.right);
            }
            TreeNode s = q.poll();
            out.add(s.val);
            if (s.left != null)
                q.add(s.left);
            if (s.right != null)
                q.add(s.right);
            
        }
        return out;
    }
}