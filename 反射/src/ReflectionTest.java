import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class Dog {
    public String name;
    int age;
    private String dogID;

    private Dog(String name){
        this.name = name;
    }

    public Dog(String name, int age, String dogID) {
        this.name = name;
        this.age = age;
        this.dogID = dogID;
    }

    public void selfIntroduce() {
        System.out.println("my name is " + name);
    }

    private void setDogID(String id) {
        dogID = id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dogID='" + dogID + '\'' +
                '}';
    }
}


public class ReflectionTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Dog> dogClass = Dog.class;
        Constructor<Dog> cons = dogClass.getDeclaredConstructor(String.class, int.class, String.class);
        Dog wawa = cons.newInstance("wawa", 5, "340321199609012798");
//        wawa.selfIntroduce();
        System.out.println(wawa);

        // 调用私有的构造方法
        Constructor<Dog> privateCons = dogClass.getDeclaredConstructor(String.class);
        privateCons.setAccessible(true);
        Dog privateDog = privateCons.newInstance("私家狗");
        System.out.println(privateDog);

        // 调用私有属性
        Field name = dogClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(privateDog,"新私家狗");
        System.out.println(privateDog);

    }
}
