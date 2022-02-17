package oob;

public class BlockTest {
    public static void main(String[] args) {
        Car.price = 123452.12;
        Car c1 = new Car();
        Car c2 = new Car();
    }
}

class Car{
    static double price;
    String name;
    String color;

    static {
        System.out.println("我是一个静态代码块，随着类的加载而执行。只执行一次");
    }

    {
        System.out.println("我是一个非静态代码块，随着对象的创建而执行");
    }
}
