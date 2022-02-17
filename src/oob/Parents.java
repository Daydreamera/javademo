package oob;

public class Parents {

    long id = 1001;
    String name;
    int age;

    public Parents() {
        System.out.println("我是爹爹，我一直在");
    }

    public Parents(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void makeMoney() {
        System.out.println("我可以赚钱");
    }

    static void print() {
        System.out.println("我是父类的print方法");
    }
}

class Children extends Parents {
    long id = 1002;

    public Children(String name) {
        this.name = name;
    }

    public void makeMoney() {
        System.out.println("我也可以赚钱");
    }

    static void print() {

        System.out.println("我是子类的print方法");
    }

    public static void main(String[] args) {
        Children c = new Children("儿子");
        System.out.println(c.name);
        c.print();
        Parents p = new Children("he");
        System.out.println(p.id);
    }


}