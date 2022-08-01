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
        Map<Integer, TreeNode> parentsMap = new HashMap<>();
        setParent(root, null, parentsMap);  
        return bfs(target, k, parentsMap);
    }

  public ArrayList<Integer> bfs(TreeNode targetNode, int k, Map<Integer, TreeNode> parentsMap) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Set<Integer> visited = new HashSet<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(targetNode);
    visited.add(targetNode.val);
    int distance = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (distance == k)
          result.add(node.val);
        if (node.left != null && !visited.contains(node.left.val)) {
          q.add(node.left);
          visited.add(node.left.val);
        }
        if (node.right != null && !visited.contains(node.right.val)) {
          q.add(node.right);
          visited.add(node.right.val);
        }
        if (parentsMap.get(node.val) != null && !visited.contains(parentsMap.get(node.val).val)) {
          q.add(parentsMap.get(node.val));
          visited.add(parentsMap.get(node.val).val);
        }
      }
      if (distance == k)
        break;
      distance++;
    }
    return result;
  }

  public void setParent(TreeNode child, TreeNode parent, Map<Integer, TreeNode> parentsMap) {
    if (child == null)
      return;
    parentsMap.put(child.val, parent);
    setParent(child.left, child, parentsMap);
    setParent(child.right, child, parentsMap);
  }
}