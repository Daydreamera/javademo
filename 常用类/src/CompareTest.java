import java.util.Arrays;

class Person implements Comparable {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            return Integer.compare(this.age, ((Person) o).age);
        }
        throw new RuntimeException("传入的类型不一致...");
    }
}

public class CompareTest {

    public static void main(String[] args) {
        Person[] persons = new Person[4];
        persons[0] = new Person("Hadoop", 22);
        persons[1] = new Person("Hive", 19);
        persons[2] = new Person("Zookeeper", 21);
        persons[3] = new Person("Hbase", 19);
        Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));
    }
}
