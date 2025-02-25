import java.util.HashMap;

public class LC560 {
    /*
     * Leetcode Problem 560: Subarray Sum Equals K
     * https://leetcode.com/problems/subarray-sum-equals-k/description/
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1 };
        System.out.println(subarraySum(arr, 2)); // Output: 2

        int[] arr2 = { 1, 2, 3 };
        System.out.println(subarraySum(arr2, 3)); // Output: 2

        int[] arr3 = { 1, 2, 1, 2, 1 };
        System.out.println(subarraySum(arr3, 3)); // Output: 4

        int[] arr4 = { 3, 4, 7, 2, -3, 1, 4, 2 };
        System.out.println(subarraySum(arr4, 7)); // Output: 4
    }

    private static int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
