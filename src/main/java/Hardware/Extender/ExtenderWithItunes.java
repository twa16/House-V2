/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardware.Extender;

import Hardware.Extender.Interfaces.ItunesControl;
import StartUp.Main;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author manuel
 */
public class ExtenderWithItunes extends Extender implements ItunesControl{
    public ExtenderWithItunes(String address){
        super(address);
    }
    
    public void play() {
        sendCommand("play",this.getIPAddress());
    }

    public void pause() {
        sendCommand("pause",this.getIPAddress());
    }

    public void next() {
        sendCommand("next",this.getIPAddress());
    }

    public void previous() {
        sendCommand("previous",this.getIPAddress());
    }
    
    private void sendCommand(String messagestring,String host) {

        try {
            
            int port = 7262;

            byte[] message = messagestring.getBytes();

            // Get the internet address of the specified host
            InetAddress address = InetAddress.getByName(host);

            // Initialize a datagram packet with data and address
            DatagramPacket packet = new DatagramPacket(message, message.length,
                    address, port);

            // Create a datagram socket, send the packet through it, close it.
            DatagramSocket dsocket = new DatagramSocket();
            dsocket.send(packet);
            dsocket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
