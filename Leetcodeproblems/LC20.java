import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20 {
    /*
     * LeetCode 20: Valid Parentheses
     * https://leetcode.com/problems/valid-parentheses/description/
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        System.out.println(isValid("()")); // Output: true
        System.out.println(isValid("()[]{}")); // Output: true
        System.out.println(isValid("(]")); // Output: false
        System.out.println(isValid("([)]")); // Output: false
        System.out.println(isValid("{[]}")); // Output: true
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char stacked = stack.pop();
                char mappedValue = map.get(stacked);
                if (!(curr == mappedValue)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
