public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;     // Number of rows in the original matrix
        int n = matrix[0].length;  // Number of columns in the original matrix

        // Create a new matrix for the transposed matrix
        int[][] transposed = new int[n][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }

    public static void transposeSquareMatrixInPlace(int[][] matrix) {

        int n = matrix.length;  // Since it's a square matrix, the number of rows is equal to the number of columns

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <=i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] transposed = transpose(matrix);

        for(int[] nums : transposed) {
            for(int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("==========");
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        transposeSquareMatrixInPlace(matrix2);
        for(int[] nums : matrix2) {
            for(int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
