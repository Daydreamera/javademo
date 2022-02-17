class Product {
    int productNum = 0;

    public synchronized void producePro() {
        if (productNum < 20) {
            productNum++;
            System.out.println(Thread.currentThread().getName() + "生产1件产品 剩余" + productNum + "件产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumPro() {
        if (productNum > 0) {
            productNum--;
            System.out.println(Thread.currentThread().getName() + "消费一件产品 剩余" + productNum + "件产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            product.producePro();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            product.consumPro();
            try {
                Thread.sleep(130);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product p = new Product();
        Producer p1 = new Producer(p);
        Consumer c1 = new Consumer(p);
        Thread tp = new Thread(p1);
        Thread tc = new Thread(c1);
        tp.setName("生产者");
        tc.setName("消费者");
        tp.start();
        tc.start();
    }
}
