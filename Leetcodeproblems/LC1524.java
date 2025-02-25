public class LC1524 {
    /*
     * Leetcode Problem 1524: Number of Sub-arrays With Odd Sum
     * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5 };
        System.out.println(numOfSubarrays(arr)); // Output: 4

        int[] arr2 = { 2, 4, 6 };
        System.out.println(numOfSubarrays(arr2)); // Output: 0

        int[] arr3 = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(numOfSubarrays(arr3)); // Output: 16

    }

    private static int numOfSubarrays(int[] arr) {
        int result = 0;
        int oddSum = 0;
        int evenSum = 1;
        int sum = 0;
        int MOD = 1000000007;

        for (int a : arr) {
            sum += a;
            if ((sum & 1) == 1) {
                // number is odd
                result = (result + evenSum) % MOD;
                oddSum++;
            } else {
                // number is even
                result = (result + oddSum) % MOD;
                evenSum++;
            }
        }

        return result;
    }
}
