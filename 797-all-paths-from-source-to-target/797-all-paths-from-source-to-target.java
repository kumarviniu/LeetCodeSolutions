class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return pathByDfs(graph, 0);
    }
    
    public List<List<Integer>> pathByDfs(int[][] graph, int node) {
        if (node == graph.length - 1) {
            List<List<Integer>> paths = new LinkedList<>();
            List<Integer> path = new LinkedList<>();
            path.add(node);
            paths.add(path);
            return paths;
        }
        
        List<List<Integer>> paths = new LinkedList<>();
        for (int neighbor : graph[node]) {
            List<List<Integer>> neighborPaths = pathByDfs(graph, neighbor);
            for (List<Integer> path : neighborPaths) {
                path.add(0, node);
                paths.add(path);
            }
        }
        
        return paths;
    }
}