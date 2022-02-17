package oob;

import java.io.*;

public class ExceptionTest {
    public static void main(String[] args) {
        FileInputStream is = null;
        try {
            File file = new File("hello.txt");
            is = new FileInputStream(file);
            int s = is.read();
            while (s != -1) {
                System.out.print((char) s);
                s = is.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到！");
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
