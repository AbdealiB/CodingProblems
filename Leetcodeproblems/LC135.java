import java.util.Arrays;

public class LC135 {
    /*
     * LeetCode 135: Candy
     * https://leetcode.com/problems/candy/description/
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        System.out.println(candy(ratings)); // Output: 5

        int[] ratings2 = { 1, 2, 2 };
        System.out.println(candy(ratings2)); // Output: 4

        int[] ratings3 = { 1, 2, 87, 87, 87, 2, 1 };
        System.out.println(candy(ratings3)); // Output: 13

        int[] ratings4 = { 1, 3, 4, 5, 2 };
        System.out.println(candy(ratings4)); // Output: 11

    }

    public static int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        return Arrays.stream(arr).sum();

    }
}
