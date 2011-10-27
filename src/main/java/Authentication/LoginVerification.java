/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import Database.UsersSQL;
import com.manuwebdev.mirageobjectlibrary.Authentication.LoginAttempt;
import com.manuwebdev.mirageobjectlibrary.Authentication.MD5;
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
        String username = la.getUsername();
        String time = la.getTimeStamp();
        String realpassword = UsersSQL.getUserPassword(username, conn);
        String hash = null;
        String hashattempt = la.getHash();
        System.out.println(la.getHash() + "\n" + la.getUsername() + "\n" + la.getTimeStamp());
        if (realpassword != null) {
            try {
                System.out.println(username + realpassword + time);
                hash = MD5.hash(username+realpassword+time);
                System.out.println("Actual hash: " + hash);
                //hashattempt = MD5.hash(username + password);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (hash.equals(hashattempt)) {
                return true;
            }
            //if(hash==null&&hashattempt==null)return false;
        } else {
            System.out.println("User Not Found: " + username);
            return false;
        }
        return false;
    }
}
