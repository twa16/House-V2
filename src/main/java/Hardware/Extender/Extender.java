/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardware.Extender;

import Hardware.Computer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author manuel
 */
public abstract class Extender extends Computer {

    public Extender(String address) {
        super(address);
    }

    public void sendRemoteSayMessage(String message) {
        say(this.getIPAddress(),message);
    }

    private void say(String host, String message) {
        try {
            byte[] messagebytes = message.getBytes();
            InetAddress address = null;
            try {
                address = InetAddress.getByName(host);
            } catch (UnknownHostException ex) {
                System.err.println(ex.getMessage());
            }
            DatagramPacket packet = new DatagramPacket(messagebytes, messagebytes.length, address, 7260);
            DatagramSocket dsocket = new DatagramSocket();
            try {
                dsocket.send(packet);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            dsocket.close();
        } catch (SocketException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
