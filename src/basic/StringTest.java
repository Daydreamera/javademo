package basic;

public class StringTest {
    public static void main(String[] args) {
        // String类型是引用类型  不是基本数据类型
        String s1 = "hello world";
        System.out.println(s1);
        String s2 = ""; // 这个可以编译
        //char c1 = '';   //编译不通过

        /* 符号运算 */
        float f1 = 9;
        float f2 = 8;
        int c = (int) (f1 / f2);
        System.out.println(c);
        // 位运算
        System.out.println(3 << 2); // 0011-->1100=12
        // 利用位运算互换两数的值
        int n1 = 12;    // 1 1 0 0
        int n2 = 5;     // 0 1 0 1
        n1 = n1 ^ n2;   // 1 0 0 1 = 9
        n2 = n1 ^ n2;   // 1 1 0 0 = 12
        n1 = n1 ^ n2;   // 0 1 0 1 = 5
        System.out.println("n1:" + n1);
        System.out.println("n2:" + n2);
        /* 三元运算符：(boolean) ? expr1 : expr2 */
        System.out.println((n1 > n2) ? n1 : n2);

    }
}
