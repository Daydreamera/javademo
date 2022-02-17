import java.util.Random;

class SubTread implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        int flag = 0;
        for (int i = 0; i < 100000000; i++) {
            if (random.nextFloat() > 0.5) {
                flag++;
            }
        }
        System.out.println(flag / 100000000.0);
    }
}


public class ThreadDemo_4 {
    public static void main(String[] args) {
        SubTread st = new SubTread();
        final Thread t1 = new Thread(st);
        final Thread t2 = new Thread(st);
        final Thread t3 = new Thread(st);
        final Thread t4 = new Thread(st);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
