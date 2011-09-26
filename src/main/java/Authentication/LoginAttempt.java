/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuel
 */
public class LoginAttempt {
    private String hash;
    private String user;
    private String time;
    public LoginAttempt(String username, String password){
        this.user=username;
        try {
            time=Time.Time.getTimeStamp();
            hash = MD5.hash(username+password+time);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginAttempt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginAttempt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean checkHash(String hash){
        if(this.hash.equals(hash)) return true;
        else{
            return false;
        }
    }
    public String getUsername(){
        return user;
    }
    public String getTimeStamp(){
        return time;
    }
    public String getHash(){
        return hash;
    }
    
}
