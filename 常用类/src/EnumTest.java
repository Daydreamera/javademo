import java.util.Arrays;

// 枚举类的创建 方式一
class Month {
    private final String name;

    private Month(String name) {
        this.name = name;
    }

    public static Month JANUARY = new Month("一月");
    public static Month FEBRUARY = new Month("二月");
    public static Month MARCH = new Month("三月");
    public static Month APRIL = new Month("四月");
    public static Month MAY = new Month("五月");
    public static Month JUNE = new Month("六月");
    public static Month JULY = new Month("七月");
    public static Month AUGUST = new Month("八月");
    public static Month SEPTEMBER = new Month("九月");
    public static Month OCTOBER = new Month("十月");
    public static Month NOVEMBER = new Month("十一月");
    public static Month DECEMBER = new Month("十二月");

    @Override
    public String toString() {
        return name;
    }
}

// 方式二
enum Season {
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");

    private final String name;

    private Season(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class EnumTest {

    public static void main(String[] args) {
        System.out.println(Month.FEBRUARY);

        System.out.println("************************************");

        System.out.println(Season.SPRING);
        System.out.println(Season.valueOf("SUMMER"));
        Season s = Season.valueOf("WINTER");
        System.out.println(s.toString());
        System.out.println(Arrays.toString(Season.values()));
    }
}
