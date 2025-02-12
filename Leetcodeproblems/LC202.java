import java.util.HashSet;

public class LC202 {
    /*
     * LeetCode 202: Happy Number
     * https://leetcode.com/problems/happy-number/description/
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */

    public static void main(String[] args) {
        System.out.println(isHappy(19)); // Output: true
        System.out.println(isHappy(2)); // Output: false
        System.out.println(isHappy(61)); // Output: false
    }

    private static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;

            // Find Sum of Squares
            while (n != 0) {
                sum += Math.pow(n % 10, 2.0);
                n = n / 10;
            }

            if ((sum == 1)) {
                return true;
            }

            n = sum;

            if (set.contains(n)) {
                return false;
            }

            set.add(n);
        }
    }
}
