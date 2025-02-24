import java.util.HashMap;
import java.util.Map;

public class LC219 {
    /*
     * LeetCode 219: Contains Duplicate II
     * https://leetcode.com/problems/contains-duplicate-ii/description/
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k)); // Output: true

        int[] nums2 = { 1, 0, 1, 1 };
        int k2 = 1;
        System.out.println(containsNearbyDuplicate(nums2, k2)); // Output: true

        int[] nums3 = { 1, 2, 3, 1, 2, 3 };
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums3, k3)); // Output: false
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i : nums) {
            if (map.containsKey(i) && Math.abs(index - map.get(i)) <= k) {
                return true;
            } else {
                map.put(i, index);
            }

            index++;
        }

        return false;
    }

}
