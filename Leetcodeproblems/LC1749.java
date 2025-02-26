public class LC1749 {
    /*
     * LC1749. Maximum Absolute Sum of Any Subarray
     * https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
     * description/
     * Kadane's Algorithm - Maximum Subarray Sum
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] nums = { 1, -3, 2, 3, -4 };
        System.out.println(maxAbsoluteSum(nums)); // Output: 5

        int[] nums1 = { 2, -5, 1, -4, 3, -2 };
        System.out.println(maxAbsoluteSum(nums1)); // Output: 8

        int[] nums2 = { 2, 5, 7, -100, -5 };
        System.out.println(maxAbsoluteSum(nums2)); // Output: 107

    }

    private static int maxAbsoluteSum(int[] nums) {
        int currSubMaxSum = nums[0];
        int maxSubSum = nums[0];

        int currSubMinSum = nums[0];
        int minSubSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSubMaxSum = Math.max(nums[i], currSubMaxSum + nums[i]);
            maxSubSum = Math.max(maxSubSum, currSubMaxSum);

            currSubMinSum = Math.min(nums[i], currSubMinSum + nums[i]);
            minSubSum = Math.min(minSubSum, currSubMinSum);

        }

        return Math.max(maxSubSum, Math.abs(minSubSum));
    }
}
