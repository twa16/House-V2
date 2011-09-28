/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication.Server;

import Authentication.LoginAttempt;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author manuel
 */
public class CommunicationThread implements Runnable{
    /**
     * Socket that handles communication
     * 
     */
    Socket skt;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    public CommunicationThread(Socket skt,Connection conn){
        try {
            this.skt=skt;
            ois=new ObjectInputStream(skt.getInputStream());
            oos=new ObjectOutputStream(skt.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(CommunicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run() {
        try {
            Object o=ois.readObject();
            LoginAttempt la=(LoginAttempt)o;
            
            
        } catch (IOException ex) {
            Logger.getLogger(CommunicationThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
