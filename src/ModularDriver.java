import java.sql.Connection;
import java.sql.DriverManager;

public class ModularDriver {
    private static String url;
    private static String user;
    private static String password;

    ModularDriver(String url, String user, String password){
        boolean b = (user == null || user.isEmpty()) || (password == null || password.isEmpty());
        if ((url == null || url.isEmpty()) || b) {
            throw new IllegalArgumentException("Database connection parameters cannot be null");
        }
        if (!url.startsWith("jdbc:mysql://")) {
            throw new IllegalArgumentException("URL must start with 'jdbc:mysql://'");
        }
        if (user.length() < 3 || password.length() < 3) {
            throw new IllegalArgumentException("Username and password must be at least 3 characters long");
        }
        // if all the checks pass, set the static variables
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
