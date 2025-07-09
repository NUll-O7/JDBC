import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriver {
    // JDBC Boiler plate
    // The database connection URL and credentials
    // these are to be final and static
    private static final String url = "jdbc:mysql://127.0.0.1:3306/";
    private static final String user = "dhruv-soni";
    private static final String password = "17052006";

    //static block is used to load the driver which in this case is
    // mysql.connector.j
    // the driver is a library which is used to connect to the database
    // driver class is "com.mysql.cj.jdbc.Driver"
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver: " + e.getMessage());
        }
    }

    // this method is used to get the connection to the database
    // this section is added to make the connection modular
    // this can also be called normally inside the main method to get the connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
