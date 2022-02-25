package easy;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class ArrayReverse {
    public static void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            System.out.println(Arrays.toString(s));
        } else {
            int l = 0, r = s.length - 1;
            while (l < r) {
                s[l] = (char) ((int) s[l] ^ (int) s[r]);
                s[r] = (char) ((int) s[l] ^ (int) s[r]);
                s[l] = (char) ((int) s[l] ^ (int) s[r]);
                l++;
                r--;
            }
            System.out.println(Arrays.toString(s));
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }
}
