 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.RequestTypeActions;

import com.manuwebdev.mirageobjectlibrary.Network.RequestTypes;
import java.net.Socket;

/**
 *
 * @author Manuel Gauto
 */
public class Authentication extends RequestTypeAction{

    @Override
    public boolean action(Socket Socket, String RequestType) {
        if(RequestType.equals(RequestTypes.AUTHENTICATION)){
            return true;
        }
        else {
            return false;
        }
    }
    
}
