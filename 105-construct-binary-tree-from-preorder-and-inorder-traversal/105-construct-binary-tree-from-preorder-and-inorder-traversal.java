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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        return buildTree(preorderList, inorderList);
        
    }
    
    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
       if (preorder.isEmpty())
           return null;
        
        int index = inorder.indexOf(preorder.get(0));
        int size = preorder.size();
        
        TreeNode root = new TreeNode(preorder.get(0));      
        root.left = buildTree(preorder.subList(1, index + 1), inorder.subList(0, index));
        root.right = buildTree(preorder.subList(index + 1, size), inorder.subList(index + 1, size));

        return root;
    }
}