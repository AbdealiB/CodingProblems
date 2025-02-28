import java.util.Arrays;
import java.util.HashMap;

public class LC509 {
    /*
     * LC509. Fibonacci Number
     * https://leetcode.com/problems/fibonacci-number/description/
     * Dynamic Programming (Memoization)
     * Time Complexity: O(1) with memoization
     * Space Complexity: O(1) with memoization
     */

    // private static HashMap<Integer, Integer> dp;
    private static int[] primitiveDP;

    public static void main(String[] args) {
        // dp = new HashMap<>();
        primitiveDP = new int[100];
        for (int i = 0; i < primitiveDP.length; i++) {
            Arrays.fill(primitiveDP, -1);
        }

        System.out.println(fibonacci(2)); // Output: 1

        // dp = new HashMap<>();
        primitiveDP = new int[100];
        for (int i = 0; i < primitiveDP.length; i++) {
            Arrays.fill(primitiveDP, -1);
        }

        System.out.println(fibonacci(3)); // Output: 2

        // dp = new HashMap<>();
        primitiveDP = new int[100];
        for (int i = 0; i < primitiveDP.length; i++) {
            Arrays.fill(primitiveDP, -1);
        }

        System.out.println(fibonacci(20)); // Output: 6765
    }

    private static int fibonacci(int number) {
        // if (dp.containsKey(number)) {
        // dp.get(number);
        // }

        if (primitiveDP[number] != -1) {
            return primitiveDP[number];
        }

        int result;

        if (number <= 1) {
            result = number;
        } else {
            result = fibonacci(number - 1) + fibonacci(number - 2);
        }

        // dp.put(number, result);
        primitiveDP[number] = result;
        return result;
    }
}
