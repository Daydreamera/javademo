import org.junit.Test;

import java.io.*;
import java.util.Locale;

public class Exercise {
    @Test
    public void test() throws FileNotFoundException {
        /**
         * 修改打印流的流向 写入文件中
         */
        FileOutputStream fos = new FileOutputStream(new File("assii.txt"));
        PrintStream ps = new PrintStream(fos);

        System.setOut(ps);

        for (int i = 0; i < 255; i++) {
            System.out.print((char) i);
        }
        ps.close();

    }

    @Test
    public void dataOutputStreamTest() throws IOException {
        /**
         * 数据流的使用：将内存中的数据持久化到文件中或者从文件中将数据加载到内存中
         */
        FileOutputStream fos = new FileOutputStream("member_to_disk.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("王大锤");
        dos.writeInt(30);
        dos.writeBoolean(true);

        dos.close();
    }

    @Test
    public void dataInputStreamTest() throws IOException {
        /**
         * 数据流的使用：将内存中的数据持久化到文件中或者从文件中将数据加载到内存中
         */
        FileInputStream fis = new FileInputStream("member_to_disk.txt");
        DataInputStream dis = new DataInputStream(fis);

        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        dis.close();
        System.out.println("name:" + name + "\nage:" + age + "\nisMale:" + isMale);
    }


    public static void main(String[] args) throws IOException {
        /**
         * 从键盘输入字符串并转换成大写
         */
        InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println("请输入字符串：");
        BufferedReader br = new BufferedReader(isr);
        while (true) {
            String data = br.readLine();
            if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                System.out.println("程序结束");
                break;
            }
            System.out.println(data.toUpperCase());
        }
    }
}
