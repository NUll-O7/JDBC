import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Basics {
    public static void main(String[] args) {
        // JDBC
        // These below are the methods to connect to the database and execute queries
        // Statement is used to execute queries
        // ResultSet is used to get the results which are in the form of a table
        // PreparedStatement is used to execute queries with parameters
        // Connection is used to connect to the database
        // SQLException is used to handle errors
        Statement statement;
        ResultSet resultSet;
        try {
            Connection connection = LoadDriver.getConnection();
            System.out.println("Connection successful!");
            statement = connection.createStatement();
            statement.execute("Use JDBC");
            String query = "Insert into users (id, name, Phone) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "Dhruvika");
            preparedStatement.setString(3, "1234587819");
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
