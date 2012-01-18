/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.ArrayList;

/**
 *
 * @author Manuel Gauto
 */
public class MirageServer {
    ArrayList<MirageModule> Modules=new ArrayList<MirageModule>();
    
    public void startModules(){
        int i=0;
        while(i<=Modules.size()){
            MirageModule module=Modules.get(i);
            Thread t = new Thread(module);
            module.linkThread(t);
            t.start();
        }
    }
    
    public void addModule(MirageModule module){
        Modules.add(module);
        System.out.println("Module Started: "+module.getName());
    }
    
    public MirageModule getModuleByName(String modulename){
        int i=0;
        while(i<=Modules.size()){
            MirageModule module=Modules.get(i);
            if(module.getName().matches(modulename))return module;
        }
        return null;
    }
}
