package codingProblems.LeetcodeProblems;

import java.util.Arrays;

public class LC134 {
    /*
     * LeetCode 134: Gas Station
     * https://leetcode.com/problems/gas-station/description/
     * Time complexity: O(n)
     * Space complexity: O(1)
     * Key: If the total gas is greater than or equal to the total cost, there must
     * be a solution.
     * 
     */
    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas, cost)); // Output: 3

        int[] gas1 = { 4, 5, 2, 6, 5, 3 };
        int[] cost1 = { 3, 2, 7, 3, 2, 9 };
        System.out.println(canCompleteCircuit(gas1, cost1)); // Output: -1
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int count = Arrays.stream(gas).sum() - Arrays.stream(cost).sum();
        // If the total gas is less than the total cost, there is no solution.
        if (count < 0) {
            return -1;
        }

        int start = 0, tank = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}
