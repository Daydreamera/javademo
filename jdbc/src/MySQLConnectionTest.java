import java.sql.*;

class MySQLConnection {

    private String host;
    private int port;
    private String user;
    private String password;
    private String database;

    public MySQLConnection() {
    }

    public MySQLConnection(String host, int port, String user, String password, String database) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

}

public class MySQLConnectionTest {
    public static void main(String[] args) {
        MySQLConnection mc = new MySQLConnection("172.20.8.191", 3306, "daydreamer", "Datayes@123", "kaizzi");
        String url = "jdbc:mysql://" + mc.getHost() + ":" + mc.getPort() + "/" + mc.getDatabase();
        String user = mc.getUser();
        String passwd = mc.getPassword();

        String sql = "select * from person";

        Connection connection = null;
        Statement statement = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接
            connection = DriverManager.getConnection(url, user, passwd);
            // 获得执行SQL对象
            statement = connection.createStatement();
            // 执行sql
            ResultSet rs = statement.executeQuery(sql);
            // 遍历结果集
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类，加载驱动失败！");
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}