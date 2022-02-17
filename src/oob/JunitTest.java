package oob;

import org.junit.Test;

public class JunitTest {
    @Test
    public void testEquals() {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abd");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }

    @Test
    public void testWrapperTransform() {
        int a = 10;
        Integer A = new Integer(a);
        System.out.println("我是大A，我的类型是：" + A.getClass());

        int a1 = A.intValue();
        System.out.println("我是小a1，我的值是：" + a1);

        String s = "1234.45";
        Double sd = Double.parseDouble(s);
        System.out.println("我是sd，我的类型是：" + sd.getClass());

    }
}
