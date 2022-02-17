package oob;
public class PersonTest {
    public static void PersonShow(Person p){
        p.eat();
        p.sleep();
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "人类";
        p.age = 99;

        Man m1 = new Man();
        System.out.println(m1.name);
        m1.sleep();

        Person pm = new Man();
        pm.sleep();
//        System.out.println(pm.mascle);

        Person pw = new Woman();

        Woman w = new Woman();

        PersonShow(p);
        PersonShow(pm);
        PersonShow(pw);
        PersonShow(w);

        System.out.println();
    }
}


class Person{
    String name = "renlei";
    int age;

    public void eat(){
        System.out.println("人要吃饭~~~");
    }

    public void sleep(){
        System.out.println("人也要睡觉~~~");
    }
}

class Man extends Person{
    String muscle = "我有健硕的肌肉";

    @Override
    public void eat() {
        System.out.println("男人吃的很多...");
    }

    @Override
    public void sleep() {
        System.out.println("男人睡得很沉...");
    }
}

class Woman extends Person{
    String Beauty;

    @Override
    public void eat() {
        System.out.println("女人吃的很少…………");
    }

    @Override
    public void sleep() {
        System.out.println("女人不爱睡觉…………");
    }
}