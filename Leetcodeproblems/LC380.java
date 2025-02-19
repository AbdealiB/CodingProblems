import java.util.HashSet;
import java.util.Set;

public class LC380 {
    /*
     * LeetCode 380: Insert Delete GetRandom O(1)
     * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
     * Time complexity: O(1)
     * Space complexity: O(n)
     */

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1)); // Output: true
        System.out.println(obj.remove(2)); // Output: false
        System.out.println(obj.insert(2)); // Output: true
        System.out.println(obj.getRandom()); // Output: 1 or 2
        System.out.println(obj.remove(1)); // Output: true
        System.out.println(obj.insert(2)); // Output: false
        System.out.println(obj.getRandom()); // Output: 2
    }

    private static class RandomizedSet {
        Set<Integer> set;

        public RandomizedSet() {
            set = new HashSet<>();
        }

        public boolean insert(int val) {
            return set.add(val);
        }

        public boolean remove(int val) {
            return set.remove(val);
        }

        public int getRandom() {
            int random = (int) (Math.random() * set.size());
            return (int) set.toArray()[random];
        }
    }
}
