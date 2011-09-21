/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication.Server;

/**
 *
 * @author manuel
 */
public class AuthenticationServer{
    Thread server;
    public AuthenticationServer(){
    }
    
    public Thread getThread(){
        return server;
    }
        
    public void start(){
        server = new Thread(new AuthenticationServerThread());
        server.start();
    }
    
}
class AuthenticationServerThread implements Runnable{

    public void run() {
        
    }
    
}