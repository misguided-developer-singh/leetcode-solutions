import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        // Map to store the frequency of the prefix sums modulo k
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //This accounts for the case where the prefix sum itself is divisible by k

        int count = 0;
        int sum = 0;

        for(int num : nums) {
            sum = sum + num;
            int remainder = sum %k;
            if(remainder < 0) {
                sum = sum + k;
            }
            // If we've seen this remainder before, it means there's a subarray
            // with sum divisible by k
            count = count + map.getOrDefault(remainder, 0);

            // Update the frequency of this remainder
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[] { 4,5,0,-2,-3,1 }, 5));
        System.out.println(subarraysDivByK(new int[] { 5 }, 9));
    }

}
