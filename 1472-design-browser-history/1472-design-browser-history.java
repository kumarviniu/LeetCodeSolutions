class BrowserHistory {
    List<String> visitedPages;
    int currentIdx;
    int end;
    
    public BrowserHistory(String homepage) {
        visitedPages = new ArrayList<>();
        visitedPages.add(homepage);
        currentIdx = 0;
        end = 0;
    }
    
    public void visit(String url) {
        if (visitedPages.size() > currentIdx + 1)
            visitedPages.set(currentIdx + 1, url);
        else
            visitedPages.add(url);
        currentIdx++;
        end = currentIdx;
    }
    
    public String back(int steps) {
        int idx = Math.max(0, currentIdx - steps);
        currentIdx = idx;
        return visitedPages.get(currentIdx);
    }
    
    public String forward(int steps) {
        int idx = Math.min(end, currentIdx + steps);
        currentIdx = idx;
        return visitedPages.get(currentIdx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */