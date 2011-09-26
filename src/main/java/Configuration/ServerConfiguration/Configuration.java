/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration.ServerConfiguration;

import com.manuwebdev.ConfigurationFileLoader.Loading.ConfigurationFileLoader;

/**
 *
 * @author manuel
 */
public class Configuration {
    private ConfigurationFileLoader config;
    
    public Configuration(String fpath){
        config = new ConfigurationFileLoader(fpath);
        System.out.println("Configuration File Parsing Loaded.");
    }
    
    public String getValue(String key){
        return config.getValue(key);
    }
    
}
