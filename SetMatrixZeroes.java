
/*
Given an m x n integer matrix , if an element is 0, set its entire row and column to 0's.
    Time complexity: O(m*n)
    Space complexity: O(m+n)
 */

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //Arrays to mark the rows and columns to be zeroed
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        // Step 1: Mark the rows and columns that need to be zeroed
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Step 2: Set the elements to zero based on the rows and columns arrays
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,1,1 },
                { 1,0,1 },
                { 1,1,1 } };

        setZeroes(matrix);

        for(int[] nums : matrix) {
            for(int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
