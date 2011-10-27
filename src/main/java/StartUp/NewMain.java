/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StartUp;

import com.manuwebdev.mirageobjectlibrary.Authentication.LoginAttempt;
import com.manuwebdev.mirageobjectlibrary.Authentication.MD5;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Gauto
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            //Configuration Initialization
            //Configuration config = new Configuration("C:/mirage.conf");
            
            //MYSQL Server
            //MYSQLServer mysql=new MYSQLServer(config);
            //mysql.connect();
            
           LoginAttempt la=new LoginAttempt("test","test");
            //System.out.println(la.getHash()+"\n"+la.getUsername()+"\n"+la.getTimeStamp());
            //System.out.println(LoginVerification.checkLogin(la, mysql.getSQLConnection()));
            System.out.println(MD5.hash("testtest"+la.getTimeStamp())+"\n");
            System.out.println(la.getHash());
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
