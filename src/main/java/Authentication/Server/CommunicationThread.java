/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication.Server;

import Authentication.LoginVerification;
import Database.UsersSQL;
import com.manuwebdev.mirageobjectlibrary.Authentication.LoginAttempt;
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
    Connection conn;
    public CommunicationThread(Socket skt,Connection conn){
        try {
            this.skt=skt;
            ois=new ObjectInputStream(skt.getInputStream());
            oos=new ObjectOutputStream(skt.getOutputStream());
            this.conn=conn;
        } catch (IOException ex) {
            Logger.getLogger(CommunicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run() {
        try {
            Object o=ois.readObject();
            LoginAttempt la=(LoginAttempt)o;
            boolean OK=LoginVerification.checkLogin(la, conn);
            if(OK){
                oos.writeObject(UsersSQL.getUserObject(la.getUsername(), conn));
            }
            else{
                oos.writeObject(null);
            }
            //User u=new User(la.getUsername(),);
            
        } catch (IOException ex) {
            Logger.getLogger(CommunicationThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
