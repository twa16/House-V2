/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StartUp;

import Authentication.Server.AuthenticationServerModule;
import Configuration.ServerConfiguration.Configuration;
import Database.MYSQLModule;
import Server.MirageServer;

/**
 *
 * @author Manuel Gauto
 */
public class StartUp {

    /**
     * Configuration file used by MirageServer
     */
    public static String Config_File = "";

    /**
     * Server container
     */
    private static MirageServer Mirage;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Configuration Initialization
        Configuration config = new Configuration(args[0]);
        
        //MirageServer object
        Mirage=new MirageServer(config);
        
        //Add MYSQL
        Mirage.addModule(new MYSQLModule());
        
        //Add AuthenticationServer
        Mirage.addModule(new AuthenticationServerModule());
        
    }
}
