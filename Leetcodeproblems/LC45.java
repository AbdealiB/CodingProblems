public class LC45 {
    /*
     * LeetCode 45: Jump Game II
     * https://leetcode.com/problems/jump-game-ii/description/
     * Greedy approach
     * Time complexity: O(n)
     * Space complexity: O(1)
     */

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(jump(nums)); // Output: 2

        int[] nums2 = { 2, 3, 0, 1, 4 };
        System.out.println(jump(nums2)); // Output: 2

        int[] nums3 = { 2, 3, 0, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(jump(nums3)); // Output: 9
    }

    private static int jump(int[] nums) {
        int totalJumps = 0;
        int destination = nums.length - 1;

        int coverage = 0;
        int lastJumpedIdx = 0;

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpedIdx) {
                lastJumpedIdx = coverage;
                totalJumps++;

                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }
}
