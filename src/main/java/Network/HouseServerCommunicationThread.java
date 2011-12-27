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

    private Socket socket;
    private InputStream InputStream;
    private OutputStream OutputStream;
    private ObjectOutputStream ObjectOutputStream;
    private ObjectInputStream ObjectInputStream;
    private Scanner Scanner;
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
