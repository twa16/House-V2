/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardware;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuel
 */
public abstract class Computer {
    InetAddress Address;
    public Computer(String Name){
        try {
            Address = InetAddress.getByName(Name);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Computer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public InetAddress getInetAddress(){
        return Address;
    }
    public String getIPAddress(){
        return Address.getHostAddress();
    }
}
