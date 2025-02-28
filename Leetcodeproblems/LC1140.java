package codingProblems.LeetcodeProblems;

import java.util.Arrays;

public class LC1140 {
    /*
     * LC1140. Stone Game II
     * https://leetcode.com/problems/stone-game-ii/description/
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * Memoization
     */

    private static int[][][] MEMO = new int[2][101][101];
    private static int N;

    public static void main(String[] args) {
        for (int i = 0; i < MEMO.length; i++) {
            for (int j = 0; j < MEMO[i].length; j++) {
                Arrays.fill(MEMO[i][j], -1);
            }
        }

        int[] piles = { 2, 7, 9, 4, 4 };
        System.out.println(stoneGameII(piles)); // Output: 10

        for (int i = 0; i < MEMO.length; i++) {
            for (int j = 0; j < MEMO[i].length; j++) {
                Arrays.fill(MEMO[i][j], -1);
            }
        }

        int[] piles1 = { 1, 2, 3, 4, 5, 100 };
        System.out.println(stoneGameII(piles1)); // Output: 104

    }

    private static int stoneGameII(int[] piles) {
        // Alice: Person 1
        // Bob: Person 0
        N = piles.length;
        return solveForAlice(piles, 1, 0, 1);
    }

    private static int solveForAlice(int[] piles, int person, int i, int M) {
        if (i >= N) {
            return 0;
        }

        if (MEMO[person][i][M] != -1) {
            return MEMO[person][i][M];
        }

        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for (int x = 1; x <= (Math.min(2 * M, N - i)); x++) {
            stones += piles[i + x - 1];

            if (person == 1) {
                result = Math.max(result, stones + solveForAlice(piles, 0, x + i, Math.max(M, x)));
            } else {
                result = Math.min(result, solveForAlice(piles, 1, x + i, Math.max(M, x)));
            }
        }

        return MEMO[person][i][M] = result;
    }
}
