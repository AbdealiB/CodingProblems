package codingProblems.LeetcodeProblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC151 {
    /*
     * LeetCode 151: Reverse Words in a String
     * https://leetcode.com/problems/reverse-words-in-a-string/description/
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // Output: "blue is sky the"
        System.out.println(reverseWords("  hello world!  ")); // Output: "world! hello"
        System.out.println(reverseWords("a good example")); // Output: "example good a"
        System.out.println(reverseWords(" Bob Loves Alice ")); // Output: "Alice Loves Bob"
        System.out.println(reverseWords("Alice does not even like bob")); // Output: "bob like even not does Alice"

        System.out.println(reverseWordsJava8("the sky is blue")); // Output: "blue is sky the"
        System.out.println(reverseWordsJava8("  hello world!  ")); // Output: "world! hello"
        System.out.println(reverseWordsJava8("a good example")); // Output: "example good a"
        System.out.println(reverseWordsJava8(" Bob Loves Alice ")); // Output: "Alice Loves Bob"
        System.out.println(reverseWordsJava8("Alice does not even like bob")); // Output: "bob like even not does Alice"
    }

    public static String reverseWordsJava8(String s) {
        String[] a = s.trim().split("\\s+");
        List<String> arr = Arrays.stream(a).collect(Collectors.toList()).reversed();

        StringBuilder sb = new StringBuilder();

        for (String str : arr) {
            sb.append(str + " ");
        }

        return sb.toString().trim();
    }

    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i != 0) {
                sb.append(arr[i] + " ");
            } else {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}
