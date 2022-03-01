package middle;

import java.util.Arrays;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 * 如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的子串
 */
public class ContainSubString {
    public static boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i <= (s2.length() - s1.length()); i++) {
            String sub = s2.substring(i, i + s1.length());
            char[] subChars = sub.toCharArray();
            char[] s1Chars = s1.toCharArray();

            Arrays.sort(subChars);
            Arrays.sort(s1Chars);
            if (Arrays.equals(subChars, s1Chars)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
