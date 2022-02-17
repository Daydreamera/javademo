package binarysearch;

public class BinarySearchInsert {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     * 思路：使用二分查找
     * num = [1,2,7,9]
     * 情况 1(target = 2)： --> return mid
     * 情况 2(target = 5)： --> return right + 1
     * 情况 3(target = 0)： --> return right + 1
     * 情况 4(target = 10)： --> return right + 1
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
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
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,7,9};
        System.out.println(searchInsert(nums, 10));
    }
}
