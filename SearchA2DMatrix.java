/*
      Convert into 1D array. Binary Search
 */
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length; // number of rows
        int column = matrix[0].length; // number of columns

        int left = 0;
        int right = row * column - 1; // total number of elements in the matrix

        while(left <= right) {
            int mid = left + (right - left) / 2;

            // Map mid to the corresponding 2D coordinates
            int midValue = matrix[mid/column][mid%column];
            
            if(midValue == target) return true;
            else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };

        System.out.println(searchMatrix(matrix1, 10));
    }
}
