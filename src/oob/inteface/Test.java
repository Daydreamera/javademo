package oob.inteface;

interface A {
    int a = 0;

    default void defacltFunc(){
        System.out.println("我是接口的默认方法");
    }
}

class B {
    int a = 1;
}

class C extends B implements A {
    public void defaultFunc(){
        System.out.println("我是子类的方法");
    }
    public void show() {
        System.out.println(super.a);
        System.out.println(A.a);
        defaultFunc();
        A.super.defacltFunc();      // 使用 接口.super.方法来调用接口中的默认方法
//        System.out.println(a); // a是不明确的

    }
}

public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.show();
    }
}
