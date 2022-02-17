package basic;

public class VariablesTest {
    /*
    * 运算自动向上转型：byte、char、short --> int --> long --> float --> double
    * 整型默认是int类型	 long l = 123123（编译不报错，int向上提升至long）
	* 浮点型默认是double类型	 float f = 123.123（编译报错，double不能隐式向下转换成float）
    * */
    public static void main(String[] args) {
        long l = 124354355489l;
        boolean flag = true;
        int xl = (int)l;
        System.out.println(xl);
    }
}
