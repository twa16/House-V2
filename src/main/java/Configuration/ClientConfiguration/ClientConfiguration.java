/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration.ClientConfiguration;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Manuel Gauto
 */
public class ClientConfiguration {
    private Map<String, Object> Data = new HashMap<String, Object>();
    
    public ClientConfiguration(){
        
    }
    
    private void addData(String name, Object data){
        Data.put(name, data);
    }
    
    private Object getData(String name){
        return Data.get(name);
    }
    
    public void setHalf(String half){
        
        
    }
}
