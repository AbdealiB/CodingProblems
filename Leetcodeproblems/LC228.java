package codingProblems.LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class LC228 {
    /*
     * LeetCode 228: Summary Ranges
     * https://leetcode.com/problems/summary-ranges/description/
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        System.out.println(summaryRanges(nums)); // Output: ["0->2","4->5","7"]

        int[] nums2 = { 0, 2, 3, 4, 6, 8, 9 };
        System.out.println(summaryRanges(nums2)); // Output: ["0","2->4","6","8->9"]
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> arrayList = new ArrayList<>();

        if (nums.length == 0) {
            return arrayList;
        }

        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if ((i == nums.length) || (nums[i] != nums[i - 1] + 1)) {
                if ((start == nums[i - 1])) {
                    arrayList.add(String.valueOf(start));
                } else {
                    arrayList.add(start + "->" + nums[i - 1]);
                }

                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return arrayList;
    }
}
