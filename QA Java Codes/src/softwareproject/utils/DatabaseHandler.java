package softwareproject.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
/**
 *
 * @author marki
 */
/*

public class DatabaseHandler {

    public static void main(String[] args) throws SQLNonTransientConnectionException 
        ,IOException, SQLException {

        String instanceConnectionName = "middle:us-central1:software-project";
        String databaseName = "SAP";

       
        String IP_of_instance = "35.226.86.133";
        String username = "software ";
        String password = "a123";

        String jdbcUrl = String.format(
            "jdbc:mysql://%s/%s?cloudSqlInstance=%s"
                + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
        IP_of_instance,
            databaseName,
            instanceConnectionName);

        Connection connection = (Connection)DriverManager.getConnection(jdbcUrl, username, password);

        try (Statement statement = connection.createStatement()) {
          ResultSet resultSet = statement.executeQuery("SHOW TABLES");
          while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
          }
        }catch(Exception e){
          e.printStackTrace();

        }

    }
}*/