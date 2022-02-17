
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class HeartBeatTest {
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("计时正在进行...");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        while (true) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date()));
            Thread.sleep(1000);
        }
    }
}
