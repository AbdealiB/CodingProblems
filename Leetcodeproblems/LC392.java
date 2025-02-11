package codingProblems.LeetcodeProblems;

public class LC392 {
    /*
     * LeetCode Problem 392. Is Subsequence
     * https://leetcode.com/problems/is-subsequence/description/
     */
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // Output: true
        System.out.println(isSubsequence("axc", "ahbgdc")); // Output: false
        System.out.println(isSubsequence("b", "abc")); // Output: true
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int i = 0;
        int j = 0;

        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return s.length() == i ? true : false;
    }
}
