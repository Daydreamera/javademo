package easy;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZero {
    public static void move(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        } else {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    index++;
                }
            }
            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 0, 2, 5, 0, 6};
        move(nums);
    }
}
