/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import Database.UsersSQL;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilities to verify login information from 
 * {@link LoginAttempt} object.
 * @author manuel
 */
public class LoginVerification {

    /**
     * Verifies login information contained in {@link LoginAttempt}
     * object
     * @param la LoginAttempt containing login data
     * @param conn Connection to MYSQL
     * @return boolean true if login is correct
     */
    public static boolean checkLogin(LoginAttempt la, Connection conn) {
        String username=la.getUsername();
        String time=la.getTimeStamp();
        String realpassword = UsersSQL.getUserPassword(username, conn);
        String hash = null;
        String hashattempt = la.getHash();
        if (realpassword != null) {
            try {
                hash = MD5.hash(username + realpassword + time);
                //hashattempt = MD5.hash(username + password);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (hash.equals(hashattempt)) {
                return true;
            }
            if(hash==null&&hashattempt==null)return false;
        } else {
            return false;
        }
        return false;
    }
}
