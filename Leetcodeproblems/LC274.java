public class LC274 {
    /*
     * LeetCode 274: H-Index
     * https://leetcode.com/problems/h-index/description/
     * Counting sort approach
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        System.out.println(hIndex(citations)); // Output: 3

        int[] citations2 = { 100 };
        System.out.println(hIndex(citations2)); // Output: 1

        int[] citations3 = { 0 };
        System.out.println(hIndex(citations3)); // Output: 0

        int[] citations4 = { 1 };
        System.out.println(hIndex(citations4)); // Output: 1

        int[] citations5 = { 1, 1 };
        System.out.println(hIndex(citations5)); // Output: 1

        int[] citations6 = { 1, 3, 2, 2, 3, 1 };
        System.out.println(hIndex(citations6)); // Output: 2
    }

    private static int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        // Count the number of citations for each paper
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }

        // For Input = { 3, 0, 6, 1, 5 }
        // Count Array = { 1, 1, 0, 1, 0, 2 }

        // Calculate the H-Index
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }
}
