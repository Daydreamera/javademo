import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DataTimeTest {

    @Test
    public void test1(){
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();

        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);

        System.out.println(ld.plusDays(5));

        Instant instant = Instant.now();
        System.out.println(instant);

    }
}
