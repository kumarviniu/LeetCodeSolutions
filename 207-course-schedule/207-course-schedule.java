class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
             
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>());
        
        for (int[] pre : prerequisites)
            graph.get(pre[0]).add(pre[1]);
        
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(i, graph, visited))
                return false;
        }
        return true;
    }
    
    public boolean dfs(int vertex, Map<Integer, List<Integer>> graph, int[] visited) {
        visited[vertex] = 1;
        for (Integer neighbor : graph.get(vertex)) {
            if (visited[neighbor] == 1 || (visited[neighbor] == 0 && !dfs(neighbor, graph, visited)))
                return false;
        }
        visited[vertex] = 2;
        return true;
    }
}