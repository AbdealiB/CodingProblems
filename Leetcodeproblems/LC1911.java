package codingProblems.LeetcodeProblems;

public class LC1911 {
    /*
     * LC1911. Maximum Alternating Subsequence Sum
     * https://leetcode.com/problems/maximum-alternating-subsequence-sum/
     * description/
     * Memoization
     * Dynamic Programming
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static int N;
    static long[][] dp;
    static long[][] dp2;

    public static void main(String[] args) {
        int[] nums = { 4, 2, 5, 3 };
        System.out.println(maxAlternatingSumMemoization(nums)); // Output: 7

        int[] nums1 = { 5, 6, 7, 8 };
        System.out.println(maxAlternatingSumMemoization(nums1)); // Output: 8

        int[] nums2 = { 6, 2, 1, 2, 4, 5 };
        System.out.println(maxAlternatingSumBU(nums2)); // Output: 10
    }

    // Memoization Approach
    private static long maxAlternatingSumMemoization(int[] nums) {
        // State of DP array is nums[i] and even / odd (0, 1)
        // Time Complexity: O(n)
        // Space Complexity: O(n)

        N = nums.length;
        dp = new long[N + 1][2];

        for (int i = 0; i < N; i++) {
            dp[i][0] = dp[i][1] = -1;
        }

        if (N <= 1) {
            return N;
        }

        return solve(nums, 0, 0);
    }

    private static long solve(int[] nums, int idx, int flag) {
        if (idx >= N) {
            return 0;
        }

        if (dp[idx][flag] != -1) {
            return dp[idx][flag];
        }

        long skip = solve(nums, idx + 1, flag);

        int val = nums[idx];

        if (flag == 1) {
            val = -1 * val;
        }

        long take = solve(nums, idx + 1, flag == 0 ? 1 : 0) + val;

        return dp[idx][flag] = Math.max(skip, take);
    }

    // Bottom Up Approach
    private static long maxAlternatingSumBU(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)

        N = nums.length;

        // State of DP is Index AND after adding the current element will the length of
        // the array will be even or odd (0 or 1)
        dp2 = new long[N + 1][2];
        for (int i = 0; i < N; i++) {
            dp2[i][0] = dp2[i][1] = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            // after take it will become even array,
            // ---------------- odd array -- + current elem , current elem (skip case)
            dp2[i][0] = Math.max(dp2[i - 1][1] - nums[i - 1], dp2[i - 1][0]);

            // after take it will become odd array,
            // ---------------- even array -- + current elem , current elem (skip case)
            dp2[i][1] = Math.max(dp2[i - 1][0] + nums[i - 1], dp2[i - 1][1]);

        }
        return Math.max(dp2[N][0], dp2[N][1]);
    }
}