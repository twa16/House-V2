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
    String hash;
    public LoginAttempt(String username, String password){
        try {
            hash = MD5.hash(username+password+Time.Time.getTimeStamp());
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
    public String getHash(){
        return hash;
    }
    public boolean checkLogin(String user, String pass){
        LoginAttempt l=new LoginAttempt(user, pass);
        return l.checkHash(hash);
    }
}
