import java.io.IOException;
import java.sql.*; 
// need to import this as the STEP 1. Has the classes that you mentioned  
public class MainApp {
    public static void main(String[] args) throws SQLNonTransientConnectionException 
        ,IOException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        String instanceConnectionName = "middle:us-central1:software-project";
        String databaseName = "SAP";

       
        String IP_of_instance = "35.226.86.133";
        String username = "software ";
        String password = "a123";

        String jdbcUrl = String.format( 
                "jdbc:mysql://" + IP_of_instance + 
                        ":3306/"+
                        databaseName +
                        "?zeroDateTimeBehavior=convertToNull"
 );

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
}