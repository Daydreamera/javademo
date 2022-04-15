import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

public class StringPrint {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        String s = new String("abc");

        // 在这里可以添加N行代码 但必须保证s引用的指向不变 最终将输出变成abcd
        // 利用反射
        Class<? extends String> stringClass = s.getClass();
        Field value = stringClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(s,"abcd".toCharArray());
        System.out.println(s);        // abcd  报错是因为jdk版本过高
    }
}
