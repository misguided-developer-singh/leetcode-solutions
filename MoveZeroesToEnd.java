
import java.util.Arrays;

public class MoveZeroesToEnd {

    public static void moveZeroesToEnd(int[] arr) {
        int lastNonZeroFoundAt = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[lastNonZeroFoundAt];
                arr[lastNonZeroFoundAt] = temp;

                lastNonZeroFoundAt++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 3, 4, 0, 5};

        moveZeroesToEnd((arr));
        System.out.println(Arrays.toString(arr));

    }
}
