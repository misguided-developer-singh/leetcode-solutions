import java.util.*;

// Intersection of Two Arrays II
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        // Sort both the arrays first...
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        // Use two pointers to find the intersection
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = { 4,9,5 };
        int[] nums2 = { 9,4,9,8,4 };

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
