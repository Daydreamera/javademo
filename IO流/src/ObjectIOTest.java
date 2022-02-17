import java.io.*;

class Person implements Serializable {
    // 在进行序列化时一同写入文件 在反序列化时会和本地类的UID进行比对  判断是否可以序列化
    private static final long serialVersionUID = 12432344783787L;

    private String name;
    private int age;
    private double IQ;

    public Person() {
    }

    public Person(String name, int age, double IQ) {
        this.name = name;
        this.age = age;
        this.IQ = IQ;
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

    public double getIQ() {
        return IQ;
    }

    public void setIQ(double IQ) {
        this.IQ = IQ;
    }


}

public class ObjectIOTest {

    public static void writeObject(Object o) {
        /**
         * 将实例化后的类持久化到磁盘
         */
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.obj"));
            oos.writeObject(o);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Object readObject() {
        /**
         * 从序列化文件中加载对象到内存
         */
        Object o = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.obj"));
            o = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (o != null) {
            return o;
        } else return null;
    }

    public static void main(String[] args) throws IOException {
        Person person = new Person("王大锤", 30, 139.3);
//        writeObject(person);
        Person p = (Person) readObject();
        System.out.println(p.getName());
    }
}
