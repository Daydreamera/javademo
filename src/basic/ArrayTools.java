package basic;

import java.util.Arrays;

import org.jetbrains.annotations.Contract;

public class ArrayTools {

    // 获取数组最大值
    public static int getMaxValue(int[] arrs) {
        int max = arrs[0];
        for (int e : arrs) {
            if (max < e) {
                max = e;
            }
        }
        return max;
    }

    // 冒泡排序
    public static void bubbleSort(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]) {
                    arrs[i] = arrs[i] ^ arrs[j];
                    arrs[j] = arrs[i] ^ arrs[j];
                    arrs[i] = arrs[i] ^ arrs[j];
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] arrs) {
        int left = 0;
        int right = arrs.length - 1;
        subQuickSort(arrs, left, right);
    }


    public static void subQuickSort(int[] arrs, int left, int right) {
        int i = left, j = right;
        if (i > j) {
            return;
        }
        int flag = arrs[left];
        while (i < j) {
            while (arrs[j] > flag && i < j) {
                j--;
            }
            arrs[i] = arrs[j];
            while (arrs[i] <= flag && i < j) {
                i++;
            }
            arrs[j] = arrs[i];
        }
        arrs[i] = flag;
        subQuickSort(arrs, left, i - 1);
        subQuickSort(arrs, i + 1, right);
    }

    // 二分查找
    public static int myBinarySearch(int[] arrs, int target) {
        int left = 0, right = arrs.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (target == arrs[mid]) {
                return mid;
            } else if (target < arrs[mid]) {
                right = mid - 1;
            } else if (target > arrs[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 数组的两种初始化方式
        int[] arrs = new int[]{1, 2, 4, 3, 45, 9, 45, 6, 5, 7, 7, 67, 76, 76, 1};
//        System.out.println(getMaxValue(arrs));
//        int[] arrsSort = bubbleSort(arrs);
        quickSort(arrs);
        for (int i : arrs) {
            System.out.print(i + "、");
        }
    }
}
