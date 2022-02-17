package maptest;

import entity.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author: Daydreamer
 * @create: 2022/1/4 10:20
 * @version: 1.0
 */

public class TreeMapTest {

    // 自然排序
    @Test
    public void test1() {
        TreeMap<User, Integer> tm = new TreeMap<>();
        tm.put(new User("KangKang", 21), 95);
        tm.put(new User("Michael", 22), 89);
        tm.put(new User("Jane", 20), 92);
        tm.put(new User("Maria", 19), 94);
//        tm.keySet().forEach(System.out::println);

        tm.keySet().stream().map(k -> k + ":" + tm.get(k)).forEach(System.out::println);
    }

    // 自定义排序
    @Test
    public void test2() {
        TreeMap<User, Integer> tm = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                if (user != null && t1 != null) {
                    return Integer.compare(user.getAge(), t1.getAge());
                } else {
                    throw new RuntimeException("RunError");
                }
            }
        });
        tm.put(new User("Jane", 20), 92);
        tm.put(new User("KangKang", 21), 95);
        tm.put(new User("Maria", 19), 94);
        tm.put(new User("Michael", 22), 89);
//        tm.keySet().forEach(System.out::println);

        tm.keySet().stream().map(k -> k + ":" + tm.get(k)).forEach(System.out::println);
    }
}
