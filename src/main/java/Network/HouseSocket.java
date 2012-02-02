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
 * Socket to communicate with extenders
 * @author Manuel Gauto
 */
public class HouseSocket implements Runnable{
    /**
     * Socket to accept connections
     */
    private ServerSocket ServerSocket;
    
    /**
     * Port to listen on
     */
    private int port=6356;
    
    /**
     * Socket that will be used to 
     * communicate with the client
     */
    private Socket socket;

    /**
     * Initialize HouseSocket with specified port
     * @param port Port to use
     */
    public HouseSocket(int port){
        //Set port number
        this.port=port;
    }
    @Override
    public void run() {
        try {
            //Initialize Socket
            ServerSocket=new ServerSocket(port);
        } catch (IOException ex) {
            //Port is probably in use or some other error(IOException)
            Logger.getLogger(HouseSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Loop forever :)
        while(true){
            try {
                //Client Connected
                socket=ServerSocket.accept();
            } catch (IOException ex) {
                //Some weird error (IOException)
                Logger.getLogger(HouseSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Create new communication thread
            Thread t=new Thread(new HouseServerCommunicationThread(socket));
            //Start the thread
            t.start();
        }
    }
    
}
