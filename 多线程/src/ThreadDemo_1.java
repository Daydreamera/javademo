import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "---" + i);
            }
            i++;
        }
    }
}


public class ThreadDemo_1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");
        t1.setPriority(10);
        t1.start();
        t2.start();
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println("我是主线程");
    }
}
