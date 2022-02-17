import org.junit.Test;

import java.io.*;

public class TestFileReader {

    @Test
    public void imageReloadTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File fr = new File("C:\\Users\\KJXHF-BJB\\Desktop\\pic\\dog.png");
            File fw = new File("C:\\Users\\KJXHF-BJB\\Desktop\\pic\\dog_copy.png");

            fis = new FileInputStream(fr);
            fos = new FileOutputStream(fw);

            byte[] buf = new byte[1024];
            int read = fis.read(buf);
            while (read != -1) {
                fos.write(buf, 0, read);
                read = fis.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("E:\\FileReaderTest.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int data = fr.read();
            while (data != -1) {
                System.out.printf(String.valueOf((char) data));
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
