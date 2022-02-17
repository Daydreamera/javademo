package exercise;

import entity.Employee;
import entity.MyDate;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet ts = new TreeSet();
        ts.add(new Employee("hadoop", 22, new MyDate("1999", "01", "01")));
        ts.add(new Employee("hive", 21, new MyDate("2000", "03", "22")));
        ts.add(new Employee("hbase", 21, new MyDate("2000", "03", "01")));
        ts.add(new Employee("zookeeper", 22, new MyDate("2000", "05", "31")));
        ts.add(new Employee("spark", 19, new MyDate("2002", "04", "30")));
        ts.forEach(System.out::println);
    }

    @Test
    public void test2(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o instanceof Employee && t1 instanceof Employee) {
                    Employee o1 = (Employee) o;
                    Employee t11 = (Employee) t1;
                    if (o1.getBirthday().getYear().compareTo(t11.getBirthday().getYear()) == 0) {
                        if (o1.getBirthday().getMonth().compareTo(t11.getBirthday().getMonth()) == 0) {
                            return o1.getBirthday().getDay().compareTo(t11.getBirthday().getDay());
                        } else {
                            return o1.getBirthday().getMonth().compareTo(t11.getBirthday().getMonth());
                        }
                    } else {
                        return o1.getBirthday().getYear().compareTo(t11.getBirthday().getYear());
                    }
                } else {
                    throw new RuntimeException("类型不匹配");
                }
            }
        };
        TreeSet ts = new TreeSet(comparator);
        ts.add(new Employee("hadoop", 22, new MyDate("1999", "01", "01")));
        ts.add(new Employee("hive", 21, new MyDate("2000", "03", "22")));
        ts.add(new Employee("hbase", 21, new MyDate("2000", "03", "01")));
        ts.add(new Employee("spark", 19, new MyDate("2002", "04", "30")));
        ts.add(new Employee("zookeeper", 22, new MyDate("2000", "01", "31")));
        ts.forEach(System.out::println);
    }
}
