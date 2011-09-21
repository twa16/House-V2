/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RemoteSay;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Manuel Gauto
 */
public class RemoteSay {
    public static void say(String host, String message){
        try {//To Family Room Start
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
                    }catch (SocketException ex) {
                        System.err.println(ex.getMessage());
                    }
    }
}
