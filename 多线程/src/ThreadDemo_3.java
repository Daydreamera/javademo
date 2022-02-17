class TicketsThread extends Thread {
    static int tickets = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张票,剩余" + tickets + "张票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }
}

public class ThreadDemo_3 {

    public static void main(String[] args) throws InterruptedException {
        TicketsThread tt1 = new TicketsThread();
        TicketsThread tt2 = new TicketsThread();
        TicketsThread tt3 = new TicketsThread();
        tt1.start();
        tt2.start();
        tt3.start();
        tt1.join();
        tt2.join();
        tt3.join();
        System.out.println("票已卖完！！！");
    }
}
