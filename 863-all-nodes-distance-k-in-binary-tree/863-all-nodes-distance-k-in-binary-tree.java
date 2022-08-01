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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    ArrayList<Integer> result = new ArrayList<>();
    find(root, target.val, k + 1, result);
    return result;
    }


  public Integer find(TreeNode tree, int target, int k, List<Integer> result) {
    if (tree == null)
      return null;

    if (tree.val == target) {
      findBelow(tree, 1, k, result);
      return 1;
    }

    Integer left = find(tree.left, target, k, result);
    if (left != null) {
      int currentDistance = left + 1;
      if (currentDistance == k)
        result.add(tree.val);
      findBelow(tree.right, currentDistance + 1, k, result);
      return currentDistance;
    } else {
      Integer right = find(tree.right, target, k, result);
      if (right != null) {
      int currentDistance = right + 1;
      if (currentDistance == k)
        result.add(tree.val);
        findBelow(tree.left, currentDistance + 1, k, result);
      return currentDistance;
    }
      }
    return null;
  } 

  public void findBelow(TreeNode root, int prevDistance, int k, List<Integer> result) {
    if (root == null)
      return;

    if (prevDistance == k) {
      result.add(root.val);
      return;
    }

    findBelow(root.left, prevDistance + 1, k, result);
    findBelow(root.right, prevDistance + 1, k, result);
  }
}