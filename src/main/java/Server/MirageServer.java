/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Configuration.ServerConfiguration.Configuration;
import java.util.ArrayList;

/**
 * Provides plugin management for Mirage
 * @author Manuel Gauto
 */
public class MirageServer {
    /**
     * Stores all Modules
     */
    ArrayList<MirageModule> Modules=new ArrayList<MirageModule>();
    
    /**
     * Configuration file
     */
    Configuration configuration;
    
    /**
     * Create MirageServer instance
     * @param configuration 
     */
    public MirageServer(Configuration configuration){
        this.configuration=configuration;
    }
    /**
     * Starts all loaded modules
     */
    public void startModules(){
        int i=0;
        while(i<=Modules.size()){
            MirageModule module=Modules.get(i);
            module.startModule(this);
            System.out.println("Module Started: "+module.getName());
        }
    }
    
    /**
     * Loads a module to Mirage
     * @param module Module to add
     */
    public void addModule(MirageModule module){
        Modules.add(module);
        System.out.println("Module Loaded: "+module.getName());
    }
    
    /**
     * Get a module by its name. Returns null if the modules was not found.
     * @param modulename Module to get
     * @return Module that was requested
     */
    public MirageModule getModuleByName(String modulename){
        int i=0;
        while(i<=Modules.size()){
            MirageModule module=Modules.get(i);
            if(module.getName().matches(modulename)) return module;
        }
        return null;
    }
    
    /**
     * Get configuration file
     * @return Configuration file
     */
    public Configuration getConfiguration(){
        return configuration;
    }
}
