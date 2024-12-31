import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    // Helper function to calculate the sum of the squares of digits of a number
    private int getSumOfSquares(int n) {
        int sum = 0;

        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            // If we encounter a number we've seen before, we are in a cycle
            if(set.contains(n)) {
                return false;
            }
            // Add the current number to the set of seen numbers
            set.add(n);
            // Update n to the sum of the squares of its digits
            n = getSumOfSquares(n);
        }
        return true;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(2));
    }
}
