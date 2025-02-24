import java.util.Arrays;
import java.util.stream.Collectors;

public class LC6 {
    /*
     * LeetCode 6: ZigZag Conversion
     * https://leetcode.com/problems/zigzag-conversion/description/
     * Time complexity: O(n)
     * Space complexity: O(n)
     */

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // Output: "PAHNAPLSIIGYIR"
        System.out.println(convert("PAYPALISHIRING", 4)); // Output: "PINALSIGYAHRPI"
        System.out.println(convert("A", 1)); // Output: "A"

    }

    private static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }

        String arr[] = new String[numRows];

        // initialize the arr from null to empty string
        Arrays.fill(arr, "");

        int i = 0;
        while (i < s.length()) {
            // vertically down
            for (int idx = 0; idx < numRows && i < s.length(); idx++) {
                arr[idx] += s.charAt(i++);
            }

            // obliquely up
            for (int idx = numRows - 2; idx > 0 && i < s.length(); idx--) {
                arr[idx] += s.charAt(i++);
            }
        }

        // join the array and return
        return Arrays.stream(arr).collect(Collectors.joining(""));
    }
}
