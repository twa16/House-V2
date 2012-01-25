/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication.Server;

import Database.MYSQLModule;
import Server.MirageModule;
import java.sql.Connection;

/**
 *
 * @author Manuel Gauto
 */
public class AuthenticationServerModule extends MirageModule {

    /**
     * Name of Module
     */
    final String NAME = "Authentication Server";
    
    /**
     * Port to use
     */
    private static final int AuthenticationServerPort = 5700;

    @Override
    public void execute() {
        MYSQLModule mysql = (MYSQLModule) getServer().getModuleByName("MYSQL");
        Connection conn = mysql.getMYSQLConnection();
        AuthenticationServer authsvr = new AuthenticationServer(AuthenticationServerPort, conn);
        authsvr.start();
    }

    /**
     * Returns port used by Authentication Server
     * @return port
     */
    public int getPort(){
        return AuthenticationServerPort;
    }
    
    /**
     * Get name of plugin
     * @return 
     */
    @Override
    public String getName() {
        return NAME;
    }
}
