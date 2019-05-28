package bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC";
    public static final String DB_USERNAME = "#";
    public static final String DB_PASSWORD = "#";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection CLASS ERROR");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection SQL ERROR");
        }
        return connection;
    }

}
