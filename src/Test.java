import java.io.PrintStream;

import static java.util.logging.Logger.global;

public class Test {
    // 可变形参
    public static void strsTest(String... strings) {
        System.out.println(strings[0] + " " + strings[1] + "! " + strings[2]);
    }

    public static void method(int a, int b) {
        PrintStream myps = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                if (x.startsWith("a")) {
                    super.println(x + "0");
                } else if (x.startsWith("b")) {
                    super.println(x + "0");
                }
            }
        };
        System.setOut(myps);
    }

    public static void main(String[] args) {
//        strsTest("hello", "world", "my name is Daydreamer");
        int a = 10;
        int b = 20;
        method(a, b);
        System.out.println("a：" + a);
        System.out.println("b：" + b);
    }


}
