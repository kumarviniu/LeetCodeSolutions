class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> adjList = adjList(pid, ppid);
        List<Integer> result = new ArrayList<>();
        dfs(adjList, kill, result);
        return result;
    }
    
    public void dfs(Map<Integer, List<Integer>> adjList, int kill, List<Integer> result) {
        result.add(kill);
        if (!adjList.containsKey(kill)) return;
        for (Integer child : adjList.get(kill)) dfs(adjList, child, result);
    }
    
    public Map<Integer, List<Integer>> adjList(List<Integer> pid, List<Integer> ppid) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            List<Integer> children = adjList.getOrDefault(ppid.get(i), new ArrayList<>());
            children.add(pid.get(i));
            adjList.putIfAbsent(ppid.get(i), children);
        }
        return adjList;
    }
}