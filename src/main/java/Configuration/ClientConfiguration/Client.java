/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration.ClientConfiguration;

import Authentication.User;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that defines the Client object
 * which carries information to the {@link Extender}s.
 * @author Manuel Gauto
 */
public class Client {
    User user;
    String Server_IP;
    /**
     * Constructor for Client object that carries information for Client.
     * 
     * @param user User Object containing the information of the user to be linked to the {@link Extender}.
     * 
     * @param IP IP Address of the Mirage server 
     */
    
    public Client(User user, String IP){
        this.user=user;
        Server_IP=IP;
    }
    
    /**
     * Returns {@link User} object that contains User information.
     * @return {@link User} Object 
     */
    public User getUserObject(){
        return user;
    }
    /**
     *  Sets Address of Server
     *  @param IP Server IP
     */
    public void setServerIP(String IP){
        Server_IP=IP;
    }
    
    /**
     * Returns address 
     * @return InetAddress Address of server
     */
    public InetAddress getServerIP(){
        try {
            return InetAddress.getByName(Server_IP);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
