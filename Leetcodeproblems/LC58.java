package codingProblems.LeetcodeProblems;

public class LC58 {
    /*
     * LeetCode Problem 58. Length of Last Word
     * https://leetcode.com/problems/length-of-last-word/description/
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   HellLLLo            World      ")); // Output: 5
        System.out.println(lengthOfLastWord("")); // Output: 0
        System.out.println(lengthOfLastWord("a ")); // Output: 1
    }

    private static int lengthOfLastWord(String a) {
        String[] truncated = a.trim().split(" ");
        for (int i = truncated.length - 1; i >= 0; i--) {
            if (!(" ".equals(truncated[i]))) {
                return truncated[i].length();
            }
        }

        return 0;
    }
}
