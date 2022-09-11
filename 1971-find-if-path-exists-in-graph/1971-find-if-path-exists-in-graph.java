class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
    if (source == destination) return true;
    Queue<Integer> q = new LinkedList<>();
	boolean[] visited = new boolean[n];	
	q.add(source);
	visited[source] = true;
	while(!q.isEmpty()) {
		Integer s = q.poll();
		for(int k = 0; k < edges.length; k++) {
			if (edges[k][0] == s) {
				if (edges[k][1] == destination) return true;
				if (!visited[edges[k][1]]) {
					visited[edges[k][1]] = true;
					q.add(edges[k][1]);
				}
			}
            else if (edges[k][1] == s) {
				if (edges[k][0] == destination) return true;
				if (!visited[edges[k][0]]) {
					visited[edges[k][0]] = true;
					q.add(edges[k][0]);
				}
			}
		}
	}
	return false;
    }
}