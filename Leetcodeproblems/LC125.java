
package codingProblems.LeetcodeProblems;

public class LC125 {
    /*
     * LeetCode 125: Valid Palindrome
     * https://leetcode.com/problems/valid-palindrome/description/
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(s)); // Output: true
        System.out.println(isValidPalindrome("race a car")); // Output: false
        System.out.println(isValidPalindrome("")); // Output: true
        System.out.println(isValidPalindrome("0P")); // Output: false
    }

    private static boolean isValidPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }

        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
