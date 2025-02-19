public class BinarySearch {
    /*
     * binSearch:
     * - Time complexity: O(log n)
     * - Space complexity: O(1)
     * 
     * binSearchRecursive:
     * - Time complexity: O(log n)
     * - Space complexity: O(log n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 5, 6, 9, 10, 11, 12, 14, 16 };
        System.out.println("Number 1 is at position: " + binSearch(nums, 16)); // Output: 10

        int[] nums1 = { 1, 3, 4, 5, 6, 9, 10, 11, 12, 14, 16 };
        System.out.println("Number 16 is at position: " + binSearchRecursive(nums1, 16, 0, nums.length)); // Output: 10

        int[] nums2 = { 1, 3, 4, 5, 6, 9, 10, 11, 12 };
        System.out.println("Number 0 is at position: " + binSearch(nums2, 0)); // Output: -1

        int[] nums3 = { 1, 3, 4, 5, 6, 9, 10, 11, 12 };
        System.out.println("Number 16 is at position: " + binSearchRecursive(nums3, 16, 0, nums.length)); // Output: -1

    }

    private static int binSearch(int[] nums, int toFind) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleNumber = nums[middle];

            if (toFind == middleNumber) {
                return middle;
            }

            if (toFind < middleNumber) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return -1;
    }

    private static int binSearchRecursive(int[] nums, int toFind, int left, int right) {
        if (right >= left && left <= nums.length - 1) {
            int middle = left + (right - left) / 2;
            int middleNumber = nums[middle];

            if (toFind == middleNumber) {
                return middle;
            }

            if (toFind < middleNumber) {
                return binSearchRecursive(nums, toFind, left, middle - 1);
            } else {
                return binSearchRecursive(nums, toFind, middle + 1, right);
            }
        }

        return -1;
    }
}
