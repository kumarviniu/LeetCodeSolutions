class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.add(num);
        if (left.size() - right.size() > 1)
            right.add(left.poll());
        if (!right.isEmpty() && left.peek() > right.peek())
            right.add(left.poll());
         if (right.size() - left.size() > 1)
            left.add(right.poll());
        
    }
    
    public double findMedian() {
        if (left.size() == right.size())
            return (double) (left.peek() + right.peek()) / 2;
        return left.size() > right.size() ? left.peek() : right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */