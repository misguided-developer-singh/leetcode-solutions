public class MaximumSumSubarrayOfLengthK {

    public static int maxSumSubarray(int[] nums, int k) {
        if(nums.length < k) throw new IllegalArgumentException("Array length must be at least k");

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        // Calculate the sum of the first 'k' elements
        for(int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        maxSum = currentSum;
        // Slide the window across the array
        for(int i = k; i < nums.length; i++) {
            // Slide the window: remove the leftmost element and add the new elemen
            currentSum += nums[i] - nums[i - k];
           // Update the maximum sum encountered
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 5, -2, 3, 2};
        int k = 3;
        System.out.println(maxSumSubarray(nums, 3));
    }
}
