/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Configuration.Keys;
import Configuration.ServerConfiguration.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Gauto
 */
public class MYSQLServer{
    /**
     * Username to login with
     */
    static String UserName;
    
    /**
     * Host Address of MYSQL server
     */
    static String Host;
    
    /**
     * Password to use
     */
    static String Password;
    
    /**
     * Port to use
     */
    static String Port;
    
    /**
     * Schema to access
     */
    static String Database;
    
    /**
     * Object representing connection to MYSQL server
     */
    static Connection connection = null;
    
    /**
     * MYSQL driver
     */
    Class driver_class = null;
    
    /**
     * 
     * @param config 
     */
    public MYSQLServer(Configuration config){
        System.out.println("Configuring MYSQL Server.");
        Host=config.getValue(Keys.MYSQL_SERVER);
        UserName=config.getValue(Keys.MYSQL_USERNAME);
        Password=config.getValue(Keys.MYSQL_PASSWORD);
        Port=config.getValue(Keys.MYSQL_PORT);
        Database=config.getValue(Keys.MYSQL_DATABASE);
    }
    
    public void connect(){
        try {
            System.out.println("Loading MYSQL JDBC Driver.");
            try {
                try {
                    Class.forName ("com.mysql.jdbc.Driver").newInstance ();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MYSQLServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(MYSQLServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(MYSQLServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Server URL: "+"jdbc:mysql://"+Host+":"+Port+"/"+Database);
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
    public void stop(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MYSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getSQLConnection(){
        return connection;
    }
}
