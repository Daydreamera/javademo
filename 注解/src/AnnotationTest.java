import org.junit.*;

/**
 * 运行结果：
 * 我是BeforeClass
 * 我是BeforeTest
 * 我是Test1
 * 我是AfterTest
 * 我是BeforeTest
 * 我是Test2
 * 我是AfterTest
 * 我是AfterClassTest
 *
 * 解析：
 * ① 一个类中会首先执行且只执行一次 `BeforeClass`
 * ② 每次执行Test之前都会执行一次 `Before`，之后会执行一次 `After`
 * ③ 一个类中会最后执行且只执行一次 `AfterClass`
 *
 */

public class AnnotationTest {

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("我是BeforeClass");
    }

    @Before
    public void beforeTest() {
        System.out.println("我是BeforeTest");
    }

    @Test
    public void test1() {
        System.out.println("我是Test1");

    }

    @Test
    public void test2() {
        System.out.println("我是Test2");

    }

    @After
    public void afterTest() {
        System.out.println("我是AfterTest");
    }

    @AfterClass
    public static void afterClassTest() {
        System.out.println("我是AfterClassTest");
    }
}
