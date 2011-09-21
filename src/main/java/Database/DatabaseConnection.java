/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Configuration.Keys;
import StartUp.Main;
import com.manuwebdev.ConfigurationFileLoader.Loading.ConfigurationFileLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Manuel Gauto <manuelg@manuwebdev.com>
 */
public class DatabaseConnection {
    static String UserName;
    static String Host;
    static String Password;
    static String Port;
    static String Database;
    static Connection connection = null;
    Class driver_class = null;

    public static void init() {
        getConfiguration();
        
        try {
            System.out.println("Attempting To Connect To MYSQL Server...");
            connection = DriverManager.getConnection("jdbc:mysql://"+Host+":"+Port+"/"+Database, UserName, Password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("##################Unable To Connect To MYSQL##################");
        }
        try {
            System.out.println("Established connection to " + connection.getMetaData().getURL());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void stop(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getConfiguration(){
        System.out.println("Loading MYSQL Configuration");
        ConfigurationFileLoader config = new ConfigurationFileLoader(Main.Config_File);
        Host=config.getValue(Keys.MYSQL_SERVER);
        UserName=config.getValue(Keys.MYSQL_USERNAME);
        Password=config.getValue(Keys.MYSQL_PASSWORD);
        Port=config.getValue(Keys.MYSQL_PORT);
        Database=config.getValue(Keys.MYSQL_DATABASE);
    }

    public static Connection getSQLConnection(){
        return connection;
    }
}
