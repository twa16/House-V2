/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Manuel Gauto
 */
abstract public class MirageModule implements Runnable{
    Thread ModuleThread;
    
    abstract public void execute();
    @Override
    public void run(){
        execute();
    }
    public void startModule(){
        onModuleStart();
    }
    abstract public void onModuleStart();
    public void linkThread(Thread thread){
        ModuleThread=thread;
    }
    public Thread getModuleThread(){
        return ModuleThread;
    }
    abstract public String getName();
    
}
