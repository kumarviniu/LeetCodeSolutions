class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = createGraph(edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (vertex == destination) return true;
            for (Integer neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
    
    Map<Integer, List<Integer>> createGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            List<Integer> out = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> in = graph.getOrDefault(edge[1], new ArrayList<>());
            out.add(edge[1]);
            in.add(edge[0]);
            graph.put(edge[0], out);
            graph.put(edge[1], in);
        }
        return graph;
    }
}