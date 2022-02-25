package easy;

import java.util.Arrays;

/**
 * 给你一个按非递减顺序排序的整数数组nums，
 * 返回每个数字的平方组成的新数组，
 * 要求也按非递减顺序排序。
 */
public class SquareArray {
    public static int[] sortedSquares(int[] nums) {
        int arrLength = nums.length;
        int[] newNums = new int[arrLength];
        int left = 0, right = arrLength - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                newNums[arrLength - 1] = (int) Math.pow(nums[right], 2);
                right--;
                arrLength--;
            } else {
                newNums[arrLength - 1] = (int) Math.pow(nums[left], 2);
                left++;
                arrLength--;
            }
        }
        return newNums;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-7, -3, 2, 3, 11};
        int[] newNums = sortedSquares(nums);
        Arrays.stream(newNums).forEach(System.out::println);
    }
}
