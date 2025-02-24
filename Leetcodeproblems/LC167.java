package codingProblems.LeetcodeProblems;

import java.util.HashMap;

public class LC167 {
    /*
     * LeetCode 167: Two Sum II - Input array is sorted
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     */

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println(result[0] + " " + result[1]); // Output: 1 2

        int[] numbers2 = { 2, 3, 4 };
        int target2 = 6;
        int[] result2 = twoSum(numbers2, target2);
        System.out.println(result2[0] + " " + result2[1]); // Output: 1 3

    }

    private static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement) + 1, i + 1 };
            }

            map.put(numbers[i], i);
        }

        return new int[0];
    }
}
