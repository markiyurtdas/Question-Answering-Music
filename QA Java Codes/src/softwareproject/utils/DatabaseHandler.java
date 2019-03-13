package softwareproject.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import softwareproject.constants.DatabaseInfo;
/**
 *
 * @author marki
 */
/*

public class DatabaseHandler {
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
}*/