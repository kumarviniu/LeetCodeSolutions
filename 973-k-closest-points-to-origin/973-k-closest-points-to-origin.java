class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> closestPoints = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));
        for (int[] point : points) {
            double distanceToOrigin = getDistanceToOrigin(point);
            Pair pair = new Pair();
            pair.distance = distanceToOrigin;
            pair.point = point;
            if (closestPoints.size() < k)
                closestPoints.add(pair);
            else if (closestPoints.peek().distance > distanceToOrigin) {
                closestPoints.poll();
                closestPoints.add(pair);
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++)
            result[i] = closestPoints.poll().point;
        return result;
    }
    
    public double getDistanceToOrigin(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
    
    public static class Pair {
        double distance;
        int[] point;
    }
} 