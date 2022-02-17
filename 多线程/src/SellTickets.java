class Tickets implements Runnable {
    // 使用synchronized修饰方法的形式保证线程安全性
    private int tickets = 100;

    public synchronized void sellTicket() {
        if (tickets > 0) {
            tickets--;
            System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + tickets + "张");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else System.exit(0);
    }

    @Override
    public void run() {
        while (true) {
            sellTicket();
        }
    }
}


public class SellTickets {
    public static void main(String[] args) {
        Tickets t = new Tickets();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
    }
}