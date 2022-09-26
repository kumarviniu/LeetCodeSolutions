class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
         Map<Integer, List<Integer>> adjList = adjList(pid, ppid);
        if (!adjList.containsKey(kill)) return Collections.singletonList(kill);
        List<Integer> result = new ArrayList<>();
        Queue<Integer> bfs = new ArrayDeque<>(pid.size());
        bfs.add(kill);
        while (!bfs.isEmpty()) {
            int process = bfs.poll();
            result.add(process);
            if (adjList.containsKey(process)) {
                for (Integer child : adjList.get(process))
                    bfs.add(child);
            }
        }
        return result;
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