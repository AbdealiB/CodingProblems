package codingProblems.LeetcodeProblems;

public class LC55 {
    /*
     * LeetCode 55: Jump Game
     * https://leetcode.com/problems/jump-game/description/
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 5 };
        System.out.println(canJump(nums)); // Output: true

        int[] nums2 = { 3, 2, 1, 0, 4 };
        System.out.println(canJump(nums2)); // Output: false

        int[] nums3 = { 2, 0, 0 };
        System.out.println(canJump(nums3)); // Output: true

        int[] nums4 = { 0 };
        System.out.println(canJump(nums4)); // Output: true

        int[] nums5 = { 0, 1 };
        System.out.println(canJump(nums5)); // Output: false

        int[] nums6 = { 1, 0 };
        System.out.println(canJump(nums6)); // Output: true

        int[] nums7 = { 3, 0, 8, 2, 0, 0, 1 };
        System.out.println(canJump(nums7)); // Output: true

    }

    private static boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }

        int lastIndex = nums.length - 1;
        int maxReach = 0;

        for (int i = 0; i <= lastIndex; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= lastIndex) {
                return true;
            }
        }

        return false;

    }
}
