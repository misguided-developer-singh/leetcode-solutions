import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.
*/
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true; // Duplicate found
            }
            set.add(num); // Add the current number to the set
        }
        return false; // No duplicates found
    }

    //  Arrays.sort(x): Time O(nLogN), Space O(1)
    public static boolean containsDuplicateV2(int[] nums) {

        // Sort the array first
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicate found

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(containsDuplicate(nums1)); //true
        System.out.println(containsDuplicate(nums2)); //false

        System.out.println(containsDuplicateV2(nums1)); //true
        System.out.println(containsDuplicateV2(nums2)); //false
    }
}
