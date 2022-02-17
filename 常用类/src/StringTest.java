import org.junit.Test;

import java.util.Arrays;

/**
 * String类是final的，不可被继承
 * 继承了Serializable接口，支持序列化操作
 * 继承了Comparable接口，支持比较大小
 * String定义的字符串具有不可变性
 */
public class StringTest {
    @Test
    public void test() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);   // s1 和 s2 指向方法区常量池中的同一块地址
        s2 = "aaa";
        System.out.println(s1 == s2);   // s2 指向方法区常量池中的一块新地址
        String s3 = s1 + "def";         // s3 指向新地址("abcdef")
    }

    @Test
    public void test1() {
        // StringBuffer是可变字符串
        StringBuffer sb = new StringBuffer("123");
        StringBuffer sb1 = sb.append("456");
        System.out.println(sb);
        System.out.println(sb == sb1);
    }

    @Test
    public void test2() {
        String s = new String("abd");
        String s1 = s.toUpperCase();
        System.out.println(s == s1);
    }

    @Test
    public void test3() {
        String s1 = "abc";
        String s2 = "ab" + "c";
        System.out.println(s1 == s2); // true
    }

    public static String myTrim(String str) {
        // 自定义trim函数，去除字符串首位空格
        // 利用字符串截取的方式
        int splitBegin = 0, splitEnd = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            splitBegin = i;
            break;
        }
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            splitEnd = i;
            break;
        }
        return str.substring(splitBegin, splitEnd);
    }


    public static String myReverse(String str, int begin, int end) {
        // 反转字符串中的指定部分
        if (str != null && str != "") {
            char[] chars = str.toCharArray();
            for (int i = begin, j = end - 1; i < j; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            return new String(chars);
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(StringTest.myTrim("sa  assas dsd   "));
        System.out.println(StringTest.myReverse("nihaoadjk", 2, 5));
    }
}
