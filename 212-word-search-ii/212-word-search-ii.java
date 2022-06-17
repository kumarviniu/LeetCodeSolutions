class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words)
            addWord(word, root);
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                dfs(board, visited, i, j, root, new StringBuilder(""), result);
        }
        return new ArrayList<>(result);
    }
    
    public void dfs(char[][] board, boolean[][] visited, int i, int j, Node root, StringBuilder word, Set<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        
        if (visited[i][j])
            return;
        
        char c = board[i][j];
        
        if (!root.map.containsKey(c))
            return;
        
        visited[i][j] = true;
        
        word.append(c);
        
        if (root.map.get(c).end) {
            result.add(word.toString());
        }
        
        dfs(board, visited, i, j + 1, root.map.get(c), word, result);
        dfs(board, visited, i, j - 1, root.map.get(c), word, result);
        dfs(board, visited, i + 1, j, root.map.get(c), word, result);
        dfs(board, visited, i - 1, j, root.map.get(c), word, result);
        
        visited[i][j] = false;
        if (!word.isEmpty())
            word.deleteCharAt(word.length() - 1);
    }
    
    public void addWord(String word, Node root) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node next = curr.map.get(c);
            if (next == null) {
                Node node = new Node();
                curr.map.put(c, node);
                next = node;
            }
            curr = next;
        }
        curr.end = true;
    }
    
    static class Node {
        Map<Character, Node> map = new HashMap<>();
        boolean end = false;
    }
}