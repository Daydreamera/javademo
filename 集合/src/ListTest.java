import entity.User;
import org.junit.Test;

import java.util.*;

public class ListTest {
    @Test
    public void test1() {
        Collection c1 = new ArrayList();
        c1.add("AA");
        c1.add("BB");
        c1.add(123);
        c1.add(new Date());
        System.out.println(c1.size());
        c1.clear();
        System.out.println(c1.size());
    }

    @Test
    public void test2() {
        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();

        c1.add("hadoop");
        c2.add("hadoop");
        c2.add("hive");

        System.out.println(c2.contains("hadoop"));
        System.out.println(c2.containsAll(c1));
    }

    @Test
    public void test3() {
        ArrayList al = new ArrayList();
        LinkedList ll = new LinkedList();
        for (int i = 0; i < 1000000; i++) {
            al.add(i);
            ll.add(i);
        }
        long start_al = System.currentTimeMillis();
        al.remove(77);
        long end_al = System.currentTimeMillis();
        System.out.println(end_al - start_al);

        long start_ll = System.currentTimeMillis();
        ll.remove(77);
        long end_ll = System.currentTimeMillis();
        System.out.println(end_ll - start_ll);
    }

    @Test
    public void test4() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o instanceof User && t1 instanceof User) {
                    int comparaNum = ((User) o).getName().compareTo(((User) t1).getName());
                    if (comparaNum == 0) {
                        return Integer.compare(((User) o).getAge(), ((User) t1).getAge());
                    } else return comparaNum;
                } else {
                    throw new RuntimeException("类型不匹配");
                }
            }
        };

        TreeSet ts = new TreeSet(comparator);

        ts.add(new User("Hadoop", 44));
        ts.add(new User("Spark", 13));
        ts.add(new User("Sqoop", 33));
        ts.add(new User("Hive", 21));
        ts.add(new User("Hbase", 14));
        ts.add(new User("Hive", 13));

        for (Object u : ts) {
            System.out.println(u);
        }

    }
}
