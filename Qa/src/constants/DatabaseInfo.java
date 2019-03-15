/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author marki
 */
public class DatabaseInfo {
    public  String instanceConnectionName = "middle:us-central1:software-project";
    public  String databaseName = "SAP";

       
    public  String IP_of_instance = "35.226.86.133";
    public  String username = "software";
    public  String password = "a123";

    public DatabaseInfo() {
    }

    public String getInstanceConnectionName() {
        return instanceConnectionName;
    }

    public void setInstanceConnectionName(String instanceConnectionName) {
        this.instanceConnectionName = instanceConnectionName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getIP_of_instance() {
        return IP_of_instance;
    }

    public void setIP_of_instance(String IP_of_instance) {
        this.IP_of_instance = IP_of_instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
