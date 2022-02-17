package oob;

public class SingletonTest {
    public static void main(String[] args) {
        EH eh1 = EH.getInstance();
        EH eh2 = EH.getInstance();

        System.out.println(eh1 == eh2);
        System.out.println("===================================");
        LH lh1 = LH.getInstance();
        LH lh2 = LH.getInstance();
        System.out.println(lh1 == lh2);
    }
}


// 饿汉式
class EH{
    private EH(){}

    private static EH eh = new EH();

    public static EH getInstance(){
        return eh;
    }
}

// 懒汉式
class LH{
    private LH(){}

    private static LH lh = null;

    public static LH getInstance(){
        if(lh == null){
            lh = new LH();
        }
        return lh;
    }
}