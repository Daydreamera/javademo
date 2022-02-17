import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadPool implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool tp = new ThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(5);
        es.execute(tp);
        es.execute(tp);
        es.shutdown();
    }
}
