import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriver {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/";
    private static final String user = "dhruv-soni";
    private static final String password = "17052006";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
