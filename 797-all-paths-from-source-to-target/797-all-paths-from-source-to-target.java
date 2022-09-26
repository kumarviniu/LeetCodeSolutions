class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        pathByDfs(graph, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void pathByDfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            path.add(node);
            result.add(path);
            return;
        }
        path.add(node);
        for (int neighbor : graph[node]) 
            pathByDfs(graph, neighbor, new ArrayList<>(path), result);
    }
}