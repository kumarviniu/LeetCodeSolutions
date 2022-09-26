class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return pathByDfs(graph, 0, new HashMap<>());
    }
    
    public List<List<Integer>> pathByDfs(int[][] graph, int node, Map<Integer, List<List<Integer>>> dp) {
        if (node == graph.length - 1) {
            List<List<Integer>> paths = new LinkedList<>();
            List<Integer> path = new LinkedList<>();
            path.add(node);
            paths.add(path);            
            return paths;
        }
        
        if (dp.containsKey(node))
            return dp.get(node);
        
        List<List<Integer>> paths = new LinkedList<>();
        for (int neighbor : graph[node]) {
            List<List<Integer>> neighborPaths = pathByDfs(graph, neighbor, dp);
            for (List<Integer> path : neighborPaths) {
                List<Integer> newPath = new ArrayList<>(path.size() + 1);
                newPath.add(node);
                newPath.addAll(path);
                paths.add(newPath);
            }
        }
        
        dp.put(node, paths);
        return paths;
    }
}