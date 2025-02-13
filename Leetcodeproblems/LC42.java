public class LC42 {
    /*
     * LeetCode 42: Trapping Rain Water
     * https://leetcode.com/problems/trapping-rain-water/description/
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height)); // Output: 6

        int[] height2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trap(height2)); // Output: 9

        int[] height3 = { 4, 2, 3 };
        System.out.println(trap(height3)); // Output: 1

        int[] height4 = { 4, 2, 3, 1 };
        System.out.println(trap(height4)); // Output: 1

    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int right = n - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (leftMax < rightMax) {
                left += 1;
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
            } else {
                right -= 1;
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
            }
        }

        return ans;
    }

}
