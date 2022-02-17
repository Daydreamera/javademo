package exercise;
import entity.User;
import org.junit.Test;
import java.util.*;

public class DeleteDuplication {
    @Test
    public void test1() {
        // 去重
        // 使用asList时要传入一个引用类型的数组
        // 如果传入的是基本数据类型的数组  则会出现以地址为元素的集合
        Integer[] ints = new Integer[]{1, 2, 3, 3, 5, 4, 5, 6, 3, 3, 2, 11, 2, 32, 12, 342};
        List<Integer> list = Arrays.asList(ints);
        list.forEach(System.out::print);
        System.out.println();
        System.out.println("=====================================");
        HashSet<Integer> hs = new HashSet<>(list);
//        hs.addAll(list);
        hs.forEach(System.out::print);
    }

    @Test
    public void test2(){
        User u1 = new User("AA",22);
        User u2 = new User("CC",23);

        HashSet<User> hs = new HashSet<>();
        hs.add(u1);
        hs.add(u2);
        hs.forEach(System.out::println);
        System.out.println("**********************************");
        //entity.User{name='AA', age=22}
        //entity.User{name='CC', age=23}

        u1.setName("BB");   // 修改了c1的 name 属性
        hs.remove(u1);
        // 重写了hashcode方法和equals方法
        // 在remove的时候会使用(“BB”,22)的hashcode值在HashSet中找
        // HashSet中此时存在的还是("AA",22)的hashcode 所以找不到 导致没有删除 所以会存在两个值
        hs.forEach(System.out::println);
        System.out.println("**********************************");
        //entity.User{name='BB', age=22}
        //entity.User{name='CC', age=23}

        hs.add(new User("BB",22));
        // 再次添加c1对象  会使用("BB",22)的hashcode比较  与删除一样  HashSet中不存在相同的  所以可以添加成功
        hs.forEach(System.out::println);
        //entity.User{name='BB', age=22}
        //entity.User{name='CC', age=23}
        //entity.User{name='BB', age=22}
        System.out.println("**********************************");

        hs.add(new User("AA",22));
        // 再次添加("AA",22)的时候  虽然hashcode相同  但是在equals的时候 原来的AA已经变成BB  所以可以添加成功
        hs.forEach(System.out::println);
        //entity.User{name='BB', age=22}
        //entity.User{name='AA', age=22}
        //entity.User{name='CC', age=23}
        //entity.User{name='BB', age=22}


    }
}
