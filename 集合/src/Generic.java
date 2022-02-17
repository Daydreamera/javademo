import java.util.List;

public class Generic<T> {
    private T t;

    public static void main(String[] args) {
        List<String> stringList = null;
        List<Integer> integerList = null;

        List<?> list = null;  // 通配符 代表暂不指定泛型

        list = stringList;
        list = integerList;

    }
}
