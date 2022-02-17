import java.time.LocalTime;
import java.util.Timer;

class MyThread_ extends Thread {
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i <= 1000000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("all time:" + (end - start));
    }
}

public class ThreadDemo_2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread_ myThread_1 = new MyThread_();
        MyThread_ myThread_2 = new MyThread_();
        myThread_1.start();
        myThread_2.start();
        myThread_1.join();
        myThread_2.join();
//        long s = System.currentTimeMillis();
//        myThread_1.run();
//        myThread_1.run();
//        long e = System.currentTimeMillis();
//        System.out.println(e - s);
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i <= 2000000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("main all time:" + (end - start));
    }
}
