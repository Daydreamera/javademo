package easy;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class StringReverse {

    public static String wordReverse(String word) {
        char[] chars = word.toCharArray();
        if (chars == null || chars.length < 2) {
            return String.valueOf(chars);
        } else {
            int l = 0, r = chars.length - 1;
            while (l < r) {
                chars[l] = (char) (chars[l] ^ chars[r]);
                chars[r] = (char) (chars[l] ^ chars[r]);
                chars[l] = (char) (chars[l] ^ chars[r]);
                l++;
                r--;
            }
            return String.valueOf(chars);
        }
    }

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        for (int i = 0;i<s1.length;i++) {
            s1[i] = wordReverse(s1[i]);
//            s1[i] = String.valueOf(new StringBuffer(s1[i]).reverse()); // 可以调用StringBuffer提供的reverse方法进行反转
        }
        return String.join(" ",s1);
    }

    public static void main(String[] args) {
        String word = "Let's take LeetCode contest";
        System.out.println(reverseWords(word));
    }
}
