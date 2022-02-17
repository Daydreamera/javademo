package oob.inteface;

interface Flyable {
    public static final int MAX_SPEED = 7900;
    public static final int MIN_SPEED = 1; // public static final可省略

    public abstract void takeoff();     // public abstract可省略

    public abstract void landing();     // public abstract可省略
}

interface Attackable {
    void attack();

    default void rzd(){
        System.out.println("我要扔炸弹了"); // jdk8 以后支持接口中方法有方法体  但是要是默认的
    }
}

class Fighter implements Flyable, Attackable {

    @Override
    public void takeoff() {
        System.out.println("战斗机要起飞了");
    }

    @Override
    public void landing() {
        System.out.println("战斗机要降落了");
    }

    @Override
    public void attack() {
        System.out.println("我要开始攻击了");
    }
}

class Plane implements Flyable {

    @Override
    public void takeoff() {
        System.out.println("飞机起飞了");
    }

    @Override
    public void landing() {
        System.out.println("飞机降落了");
    }
}

public class IntefaceTest {
    public static void main(String[] args) {
        Fighter fighter = new Fighter();
        fighter.attack();
        System.out.println("最大速度是：" + fighter.MAX_SPEED);
    }
}