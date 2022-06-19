class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Pair<Integer, Integer>> pacific = new HashSet<>();
        Set<Pair<Integer, Integer>> atlantic = new HashSet<>();
        
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, pacific, heights[0][i], 0, i);
            dfs(heights, atlantic, heights[heights.length - 1][i], heights.length - 1, i);
            
        }
        
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, pacific, heights[i][0], i, 0);
            dfs(heights, atlantic, heights[i][heights[0].length - 1], i, heights[0].length - 1);
        }
        
        
        
        pacific.retainAll(atlantic);
        
        
        
        List<List<Integer>> result = new ArrayList<>();
        Iterator value = pacific.iterator();
        while (value.hasNext()) {
            Pair<Integer, Integer> cell = (Pair<Integer, Integer>) value.next();
            List<Integer> list = new ArrayList<>();
            list.add(cell.getKey());
            list.add(cell.getValue());
            result.add(list);
        }
        return result;
    }
    
    public void dfs(int[][] heights, Set<Pair<Integer, Integer>> visited, int prev, int i, int j) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || heights[i][j] < prev || visited.contains(new Pair<Integer, Integer>(i, j)))
            return;
        visited.add(new Pair<Integer, Integer>(i, j));
        dfs(heights, visited, heights[i][j], i - 1, j);
        dfs(heights, visited, heights[i][j], i + 1, j);
        dfs(heights, visited, heights[i][j], i, j - 1);
        dfs(heights, visited, heights[i][j], i, j + 1);
    }
}