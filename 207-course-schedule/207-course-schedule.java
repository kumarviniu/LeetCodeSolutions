class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
             
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            List<Integer> out = graph.getOrDefault(pre[1], new ArrayList<>());
            out.add(pre[0]);
            graph.put(pre[1], out);
        }
        
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(i, graph, visited))
                return false;
        }
        return true;
    }
    
    public boolean dfs(int vertex, Map<Integer, List<Integer>> graph, int[] visited) {
        visited[vertex] = 1;
        if (graph.containsKey(vertex)) {
            for (Integer neighbor : graph.get(vertex)) {
                if (visited[neighbor] == 1 || (visited[neighbor] == 0 && !dfs(neighbor, graph, visited)))
                    return false;
            }
        }
        visited[vertex] = 2;
        return true;
    }
}