class Print implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + "：" + num);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }
}


public class AlternatePrintTest {
    public static void main(String[] args) {

        Print p = new Print();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t1.start();
        t2.start();
    }
}
