import java.util.HashMap;

public class LC13 {
    /*
     * LeetCode 13: Roman to Integer
     * https://leetcode.com/problems/roman-to-integer/description/
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // Output: 3
        System.out.println(romanToInt("IV")); // Output: 4
        System.out.println(romanToInt("IX")); // Output: 9
        System.out.println(romanToInt("LVIII")); // Output: 58
        System.out.println(romanToInt("LIV")); // Output: 1994
    }

    private static int romanToInt(String s) {
        int result = 0;
        int prev = 0;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = map.get(String.valueOf(s.charAt(i)));

            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }

            prev = current;
        }

        return result;
    }
} 
