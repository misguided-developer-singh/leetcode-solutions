import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        // Max heap to store the points based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1] ) - (p1[0] * p1[0]  + p1[1] * p1[1]));

        // Iterate over all points and push them into the heap
        for(int[] point : points) {
            pq.offer(point);
            // If the heap size exceeds k, remove the farthest point
            if(pq.size() > k) {
                pq.poll();
            }
        }
        // Prepare the result by extracting points from the heap
        int[][] result = new int[k][2];
        int index = 0;

        while(!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] resultantArray = kClosest(points, 2);
        for (int[] point : resultantArray) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
    }
}
