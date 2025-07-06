import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            Connection connection = LoadDriver.getConnection();
            System.out.println("Connection successful!");
            statement = connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS JDBC";
            statement.execute(sql);
            statement.execute("USE JDBC");
            statement.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255), Phone VARCHAR(255))");
            statement.execute("INSERT INTO users (id, name, Phone) VALUES (1, 'Dhruv', '1234567890')");
            statement.execute("INSERT INTO users (id, name, Phone) VALUES (2, 'Shubham', '1234567890')");
            statement.execute("INSERT INTO users (id, name, Phone) VALUES (3, 'Shivam', '1234567890')");
            rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("Phone"));
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
