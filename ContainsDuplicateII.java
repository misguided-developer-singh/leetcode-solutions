import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    // Sliding Window Approach
    public static boolean containsNearbyDuplicateV2(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int left = 0;

        for(int num : nums) {
            if(window.size() > k) {
                window.remove(nums[left]);
                left++;
            }
            if(window.contains(num)) {
                return true;
            }
            window.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,2,3,1 };
        int[] nums2 = { 1,2,3,1,2,3 };
        System.out.println(containsNearbyDuplicate(nums1, 3)); // true
        System.out.println(containsNearbyDuplicate(nums2, 2)); // false
        System.out.println(containsNearbyDuplicateV2(nums1, 3)); // true
        System.out.println(containsNearbyDuplicateV2(nums2, 2)); // false
    }
}
