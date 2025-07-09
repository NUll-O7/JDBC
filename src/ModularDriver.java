import java.sql.Connection;
import java.sql.DriverManager;

public class ModularDriver {
    private static String url;
    private static String user;
    private static String password;

    ModularDriver(String url, String user, String password){
        if (url == null || user == null || password == null) {
            throw new IllegalArgumentException("Database connection parameters cannot be null.");
        }
        if (url.isEmpty() || user.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Database connection parameters cannot be empty.");
        }
        if (!url.startsWith("jdbc:mysql://")) {
            throw new IllegalArgumentException("Invalid URL format. It should start with 'jdbc:mysql://'.");
        }

        // If all checks pass, set the static fields
        ModularDriver.url = url;
        ModularDriver.user = user;
        ModularDriver.password = password;
    }

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
