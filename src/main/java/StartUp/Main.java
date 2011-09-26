/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StartUp;

import Authentication.Server.AuthenticationServer;
import Configuration.ServerConfiguration.Configuration;
import Console.Console;
import Database.MYSQLServer;
import java.sql.Connection;

/**
 *
 * @author Manuel Gauto
 */
public class Main {

    public static String Config_File = "";
    private static final int AuthticationServerPort=5700;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Configuration Initialization
        Configuration config = new Configuration(args[0]);
        
        //Console Initialization
        initConsole();
        
        //MYSQL Server
        MYSQLServer mysql=new MYSQLServer(config);
        mysql.connect();
        
        //Authentication Server
        Connection conn=mysql.getSQLConnection();
        AuthenticationServer authsvr=new AuthenticationServer(AuthticationServerPort,conn);
        authsvr.start();
    }

    private static void initConsole() {
        Console c = new Console();
        Commands.addCommands(c);
        c.start();
    }
}
