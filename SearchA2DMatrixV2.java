
public class SearchA2DMatrixV2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of columns

        // Start from the top-right corner
        int row = 0;
        int col = n-1;

        // Continue searching while we're within bounds of the matrix
        while(row < m && col >= 0) {
            int current = matrix[row][col];

            if(current == target) {
                return true; // target found
            } else if (current < target) {
                row++; // move down if the current element is smaller than target
            } else {
                col--; // move left if the current element is larger than target
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test case 1: matrix with target present
        int[][] matrix1 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        System.out.println(searchMatrix(matrix1, 5));
        System.out.println(searchMatrix(matrix1, 15));
    }
}
