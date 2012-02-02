/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import com.manuwebdev.mirageobjectlibrary.Network.RequestTypes;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Gauto
 */
public class HouseServerCommunicationThread implements Runnable {
    /**
     * Socket to use to communicate with client
     */
    private Socket socket;
    
    /**
     * Used to accept input from socket
     */
    private InputStream InputStream;
    
    /**
     * Used to send information to client through socket
     */
    private OutputStream OutputStream;
    
    /**
     * Send objects through socket
     */
    private ObjectOutputStream ObjectOutputStream;
    
    /**
     * Accept objects from clients
     */
    private ObjectInputStream ObjectInputStream;
    
    /**
     * Read strings from InputStream
     */
    private Scanner Scanner;
    
    /**
     * Possible RequestTypes for socket
     */
    private RequestTypes RequestTypes;

    public HouseServerCommunicationThread(Socket socket) {
        this.socket = socket;
        try {
            InputStream = socket.getInputStream();
            OutputStream = socket.getOutputStream();
            ObjectInputStream = new ObjectInputStream(InputStream);
            ObjectOutputStream = new ObjectOutputStream(OutputStream);
            Scanner = new Scanner(InputStream);
        } catch (IOException ex) {
            Logger.getLogger(HouseServerCommunicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        String RequestType = Scanner.nextLine();
        if (RequestType.equals(RequestTypes.AUTHENTICATION)) {
            
        }
        if (RequestType.equals(RequestTypes.REMOTESAY)) {
            
        }
    }
}
