public class LC12 {
    /*
     * LeetCode 12: Integer to Roman
     * https://leetcode.com/problems/integer-to-roman/description
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        System.out.println(intToRoman(3)); // Output: "III"
        System.out.println(intToRoman(4)); // Output: "IV"
        System.out.println(intToRoman(9)); // Output: "IX"
        System.out.println(intToRoman(58)); // Output: "LVIII"
        System.out.println(intToRoman(1994)); // Output: "MCMXCIV"
        System.out.println(intToRoman(0)); // Output: ""

    }

    private static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,
                4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (num / values[i] > 0) {
                int count = num / values[i];
                // Append the symbol count times
                for (int j = 0; j < count; j++) {
                    sb.append(symbols[i]);
                    // Update the number
                    num = num % values[i];
                }
            }
        }

        return sb.toString();
    }
}
