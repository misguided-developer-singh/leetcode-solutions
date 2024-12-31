import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j in the array such that:
nums[i] = nums[j] and the absolute difference between i and j is at most k.
*/
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashMap to store the number and its most recent index
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            }
            // Update the map with the current index of the number
            map.put(nums[i], i);
        }
        // No such pair found
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,2,3,1 };
        int[] nums2 = { 1,2,3,1,2,3 };
        System.out.println(containsNearbyDuplicate(nums1, 3)); // true
        System.out.println(containsNearbyDuplicate(nums2, 2)); // false
    }
}
