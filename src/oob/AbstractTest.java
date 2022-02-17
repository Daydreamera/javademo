package oob;

public class AbstractTest {
    public static void main(String[] args) {
        Rose rose = new Rose("rose");
        rose.showColor();
//        rose.ghzy();

        // 匿名抽象类
        Plant narcissus = new Plant("narcissus") {
            @Override
            public void showColor() {
                System.out.println("我是" + name + "，我是白色");
            }
        };
        narcissus.showColor();
    }

}

// 抽象类不可以实例化
abstract class Plant {
    String name;

    public Plant(String name) {
        this.name = name;
    }

    public abstract void showColor();    // 抽象类不需要方法体

    public void ghzy() {
        System.out.println("我是抽象类中的非抽象方法"); // 抽象类中可以含有非抽象方法
    }
}

class Rose extends Plant {

    public Rose(String name) {
        super(name);
    }

    // 抽象类的子类必须实现抽象父类的所有抽象方法才可以不是抽象类
    @Override
    public void showColor() {
        System.out.println("我是玫瑰，我是红色");
    }
}
