import java.io.*;

public class CharacterTransTest {
    /**
     * 转换流的测试
     */
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\repository\\javase\\IO流\\src\\note.txt");
        File copyFile = new File("E:\\repository\\javase\\IO流\\src\\note_gbk.txt");

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(copyFile);

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");

        char[] chars = new char[20];
        int len;
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars, 0, len);
        }

        isr.close();
        osw.close();
    }
}
