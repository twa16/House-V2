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
public abstract class RequestTypeAction {
    private RequestTypes RequestTypes;
    public abstract boolean action(Socket Socket, String RequestType);
}
