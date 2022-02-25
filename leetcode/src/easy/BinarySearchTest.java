package easy;

/**
 * 二分查找
 * 传入的数组默认有序
 */

public class BinarySearchTest {

    // 方式一：不使用递归
    public static int search(int[] nums, int target) {
        /**
         * @param nums      升序数组
         * @param target    目标值
         * @return
         */
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 方式二：使用递归


    public static int search(int[] nums, int target, int var1, int var2) {
        /**
         * @param nums   升序数组
         * @param target 目标值
         * @param var1   起始下标
         * @param var2   结束下标
         * @return
         */
        int left = var1, right = var2;
        int mid = (left + right) / 2;
        if (left <= right) {
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
                return search(nums, target, left, right);
            } else {
                left = mid + 1;
                return search(nums, target, left, right);
            }
        } else return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
//        int index = search(nums, 9);
        int index = search(nums, -22, 0, nums.length - 1);
        System.out.println(index);


    }
}
