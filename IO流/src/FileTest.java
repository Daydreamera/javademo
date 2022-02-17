import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {

    @Test
    public void test1() throws IOException {
        File file1 = new File("hello.txt");
        System.out.println(file1.getCanonicalPath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getParent());

        File file2 = new File("D:\\software", "hello.txt");
        System.out.println(file2);
    }

    @Test
    public void test2() throws IOException {
        // 测试文件的删除、创建方法
        File file = new File("file.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
        }
    }

    @Test
    public void test3() throws IOException {
        // 测试文件夹的删除、创建方法
        File file = new File("E:\\repository\\javase\\IO流\\testDir");
        if (!file.exists()) {
            file.mkdir();
            // file.mkdirs();   // 适用于上层目录不存在时递归创建多层目录
        } else {
            file.delete();
        }
    }
}
