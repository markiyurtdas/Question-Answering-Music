import java.io.IOException;
import java.sql.*; 
import java.util.ArrayList;
import softwareproject.constants.DatabaseInfo;
// need to import this as the STEP 1. Has the classes that you mentioned  
public class MainApp {
    public static void main(String[] args) throws SQLNonTransientConnectionException 
        ,IOException, SQLException, ClassNotFoundException {

         //JSONArray artistJSON = new JSONParser().parse(new FileReader("JSONExample.json"));

        System.out.println("Connecting");






        /*
        Class.forName("com.mysql.jdbc.Driver");
        DatabaseInfo dbInfo = new DatabaseInfo();
        String instanceConnectionName =dbInfo.getInstanceConnectionName();
        String databaseName = dbInfo.getDatabaseName() ;
        String IP_of_instance =dbInfo.getIP_of_instance();
        String username =dbInfo.getUsername();
        String password = dbInfo.getPassword();
        String jdbcUrl = String.format( 
                "jdbc:mysql://" + IP_of_instance +  ":3306/"+
                        databaseName + "?zeroDateTimeBehavior=convertToNull"
 );
        String sqlInsert = "INSERT INTO `SAP`.`Artist` (`Name`, `ArtistID`, `External_urls`, `"
                   + "Followers`, `Genres`, `Href`, `"
                   + "Image_url`, `Popularity`, `Type`) "
                   + "VALUES ('eminem', 'asd5a5d', 'asda', "
                   + "45245, 'asd,asda,asd', 'asdada', "
                   + "'asdasd', 55, 'artist" +
"     ')";
        Connection connection = null; 
        Statement stmt = null;
        try (Statement statement = connection.createStatement()) {
           System.out.println("Connecting to a selected database...");
           connection = DriverManager.getConnection(jdbcUrl, username, password);
           System.out.println("Connected database successfully...");
           insertIntoDB(stmt, connection, sqlInsert);
        }catch(Exception e){
          e.printStackTrace();        }*/
    }
    
    public static void insertIntoDB (Statement stmt, Connection conn, String string) throws SQLException {
         stmt = conn.createStatement();
         stmt.executeUpdate(string);
    }
    
    
    
    public void loadArtistToDb(){
        
    }
    
    
    
}