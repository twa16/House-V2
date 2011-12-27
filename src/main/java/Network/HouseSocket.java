/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Gauto
 */
public class HouseSocket implements Runnable{
    private ServerSocket ServerSocket;
    private final int PORT=6356;
    private Socket socket;

    @Override
    public void run() {
        try {
            ServerSocket=new ServerSocket(PORT);
        } catch (IOException ex) {
            Logger.getLogger(HouseSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){
            try {
                socket=ServerSocket.accept();
            } catch (IOException ex) {
                Logger.getLogger(HouseSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread t=new Thread(new HouseServerCommunicationThread(socket));
            t.start();
        }
    }
    
}
