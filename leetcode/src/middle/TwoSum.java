package middle;

import java.util.Arrays;

/**
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按非递减顺序排列，
 * 请你从数组中找出满足相加之和等于目标数target的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你不可以重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        // 前后相加 和大左移 和小右移
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{-4,-1,0,2,5};
        System.out.println(Arrays.toString(twoSum(numbers,-2)));
    }
}
