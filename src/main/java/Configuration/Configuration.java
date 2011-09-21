/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import com.manuwebdev.ConfigurationFileLoader.Loading.ConfigurationFileLoader;

/**
 *
 * @author manuel
 */
public class Configuration {
    private static ConfigurationFileLoader config;
    
    public static void init(String fpath){
        config = new ConfigurationFileLoader(fpath);
    }

    
}
