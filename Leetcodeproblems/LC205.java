import java.util.Arrays;
import java.util.HashMap;

public class LC205 {
    /*
     * LeeetCode 205: Isomorphic Strings
     * https://leetcode.com/problems/isomorphic-strings/description/
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        System.out.println(isIsomorphicUsingCount("egg", "add")); // Output: true
        System.out.println(isIsomorphicUsingCount("foo", "bar")); // Output: false
        System.out.println(isIsomorphicUsingCount("paper", "title")); // Output: true
        System.out.println(isIsomorphicUsingCount("abab", "adcd")); // Output: false

        System.out.println(isIsomorphic("egg", "add")); // Output: true
        System.out.println(isIsomorphic("foo", "bar")); // Output: false
        System.out.println(isIsomorphic("paper", "title")); // Output: true
        System.out.println(isIsomorphic("abab", "adcd")); // Output: false
    }

    private static boolean isIsomorphicUsingCount(String s, String t) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        int[] sCount = new int[256];
        int[] tCount = new int[256];

        Arrays.fill(sCount, -1);
        Arrays.fill(tCount, -1);

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sCount[sChar] == -1 && tCount[tChar] == -1) {
                sCount[sChar] = tChar;
                tCount[tChar] = sChar;
            } else if (sCount[sChar] != tChar || tCount[tChar] != sChar) {
                return false;
            }
        }

        return true;
    }

    private static boolean isIsomorphic(String s, String t) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if ((map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i))
                    || (!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i)))) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }
}
