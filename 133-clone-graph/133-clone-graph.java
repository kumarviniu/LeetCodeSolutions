/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Pair<Node, Node>> q = new LinkedList<>();
        Node root = new Node(node.val, new ArrayList<>());
        q.add(new Pair<>(node, root));
        map.put(node, root);
        
        while (!q.isEmpty()) {
            Pair<Node, Node> pair = q.poll();
            Node old = pair.getKey();
            Node newNode = pair.getValue();
            for (Node neighbor : old.neighbors) {
                Node newNeighbor;
                if (!map.containsKey(neighbor)) {
                    newNeighbor = new Node(neighbor.val, new ArrayList<>());
                    q.add(new Pair<>(neighbor, newNeighbor));
                    map.put(neighbor, newNeighbor);
                } else
                    newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return root;
    }
}