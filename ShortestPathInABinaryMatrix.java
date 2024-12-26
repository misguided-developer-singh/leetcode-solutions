import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInABinaryMatrix {
    private static final int[][] directions = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                                                            {1, -1}, { -1, 1}, { -1, -1}, {1, 1} };

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length; //square matrix
        boolean[][] visited = new boolean[n][n];

        // If the start or end is blocked, return -1
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // Queue stores - (row, col, distance)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, 1});  // Starting at (0, 0) with distance 1
        visited[0][0] = true; // Mark as visited

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], distance = current[2];

            // If we reach the bottom-right corner
            if(r == n-1 && c == n-1) return distance;

            // Explore the 8 possible directions
            for(int i = 0; i < 8; i++) {
                int nextX = directions[i][0] + r;
                int nextY = directions[i][1] + c;

                // Check if the new position is valid and not visited
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                        && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[] {nextX, nextY, distance + 1}); // Add to queue with incremented distance
                }
            }
        }
        return -1; // if no path found
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][] { { 0,0,0 },
//                                     { 1,1,0 },
//                                     { 1,1,0 }
//                                   };

        int[][] grid = new int[][] {  { 1,0,0 }, { 1,1,0}, { 1,1,0 } };

        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
