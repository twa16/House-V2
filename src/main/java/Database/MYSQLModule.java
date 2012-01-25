/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Configuration.ServerConfiguration.Configuration;
import Server.MirageModule;
import java.sql.Connection;

/**
 *
 * @author Manuel Gauto
 */
public class MYSQLModule extends MirageModule{
    public static final String NAME="MYSQL";
    MYSQLServer mysql;
    @Override
    public void execute() {
        Configuration config=getServer().getConfiguration();
        mysql=new MYSQLServer(config);
        mysql.connect();
    }
    
    public Connection getMYSQLConnection(){
        return mysql.getSQLConnection();
    }

    @Override
    public String getName() {
        return NAME;
    }
    
}
