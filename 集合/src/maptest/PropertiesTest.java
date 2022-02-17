package maptest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: Daydreamer
 * @create: 2022/1/4 10:50
 * @version: 1.0
 */

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println("name = " + name + ", password = " + password);
        fis.close();
    }
}
