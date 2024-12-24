import java.util.Arrays;

public class MoveZeroesToStart {

    public static void moveZeroesToEnd(int[] arr) {

        int lastNonZeroFoundAt = arr.length - 1;

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[lastNonZeroFoundAt];
                arr[lastNonZeroFoundAt] = temp;

                lastNonZeroFoundAt--;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {0, 1, 2, 0, 3, 4, 0, 5};
        int[] arr = {5, 1, 2, 0, 3, 4, 0, 0, 0};
        moveZeroesToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
