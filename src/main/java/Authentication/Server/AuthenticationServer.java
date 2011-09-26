/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuel
 */
public class AuthenticationServer{
    Thread server;
    int port;
    Connection conn;
    
    public AuthenticationServer(int port, Connection c){
        this.port=port;
        this.conn=c;
    }
    
    public Thread getThread(){
        return server;
    }
        
    public void start(){
        server = new Thread(new AuthenticationServerThread(port,conn));
        server.start();
    }
    
}
class AuthenticationServerThread implements Runnable{
    int port;
    ServerSocket svrskt;
    Socket skt;
    Connection conn;
    public AuthenticationServerThread(int port, Connection conn){
        this.port=port;
        this.conn=conn;
    }
    public void run() {
        while(true){
            try {
                svrskt=new ServerSocket(port);
                skt=svrskt.accept();
            } catch (IOException ex) {
                Logger.getLogger(AuthenticationServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread t=new Thread(new CommunicationThread(skt,conn));
            t.start();
        }
    }
    
}