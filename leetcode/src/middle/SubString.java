package middle;

/**
 * 查找子串 找到返回首字母下标
 */
public class SubString {
    public static int findSubString(String s, String sub) {
        // 暴力解法
        int i = 0, j = 0, temp;
        while (i <= s.length() - sub.length()) {
            temp = i;
            j = 0;
            while (j < sub.length()) {
                if (s.charAt(temp) == sub.charAt(j)) {
                    temp++;
                    j++;
                } else {
                    i++;
                    break;
                }
            }
            if (j == sub.length()) {
                break;
            }
        }
        if (j == sub.length()) {
            return i;
        } else return -1;
    }

    public static void main(String[] args) {
        String s = "asddass";
        int t = findSubString(s, "daa");
        System.out.println(t);
    }
}
