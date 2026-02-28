import java.sql.*;

public class DBConnection {
    static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankdb",
                "root",
                "harsh20"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}