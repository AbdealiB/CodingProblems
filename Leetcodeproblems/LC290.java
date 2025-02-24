import java.util.HashMap;

public class LC290 {
    /*
     * LeetCode 290: Word Pattern
     * https://leetcode.com/problems/word-pattern/description/
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // Output: true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // Output: false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); // Output: false
        System.out.println(wordPattern("abba", "dog dog dog dog")); // Output: false
        System.out.println(wordPattern("aaa", "dog dog dog dog")); // Output: false

    }

    private static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] sArray = s.split(" ");

        if (pattern.length() != sArray.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String sString = sArray[i];

            if ((map.containsKey(pChar) && (!map.get(pChar).equals(sString)))
                    || (!map.containsKey(pChar) && map.containsValue(sString))) {
                return false;
            }
            map.put(pChar, sString);
        }

        return true;
    }
}
