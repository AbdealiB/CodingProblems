import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LC383 {
    /*
     * LeetCode Problem 383. Ransom Note
     * https://leetcode.com/problems/ransom-note/description/
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        System.out.println(canConstruct1("a", "b")); // Output: false
        System.out.println(canConstruct1("aa", "ab")); // Output: false
        System.out.println(canConstruct1("aa", "aab")); // Output: true

        System.out.println(canConstructWithHashMap("a", "b")); // Output: false
        System.out.println(canConstructWithHashMap("aa", "ab")); // Output: false
        System.out.println(canConstructWithHashMap("aa", "aab")); // Output: true

    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        int[] alpha = new int[26];

        for (char i : ransomNote.toCharArray()) {
            alpha[i - 'a']++;
        }

        for (char i : magazine.toCharArray()) {
            alpha[i - 'a']--;
        }

        boolean x = Arrays.stream(alpha).anyMatch(a -> a > 0); // This will return true if any element is greater than 0

        return !x;
    }

    public static boolean canConstructWithHashMap(String ransomNote, String magazine) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)

        HashMap<Character, Long> ransomMap = ransomNote.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, HashMap::new, Collectors.counting()));

        HashMap<Character, Long> magazineMap = magazine.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, HashMap::new, Collectors.counting()));

        for (char c : ransomMap.keySet()) {
            if (!magazineMap.containsKey(c) || magazineMap.get(c) < ransomMap.get(c)) {
                return false;
            }
        }

        return true;
    }

}
