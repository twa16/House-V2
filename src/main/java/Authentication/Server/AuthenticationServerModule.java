/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication.Server;

import Server.MirageModule;

/**
 *
 * @author Manuel Gauto
 */
public class AuthenticationServerModule extends MirageModule{
    final String NAME="Authentication Server";
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onModuleStart() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
