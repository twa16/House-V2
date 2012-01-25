/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Manuel Gauto
 */
abstract public class MirageModule implements Runnable {

    Thread ModuleThread;
    
    MirageServer Server;

    abstract public void execute();

    @Override
    public void run() {
        execute();
    }

    public void startModule(MirageServer server) {
        this.Server=server;
        ModuleThread = new Thread(this);
        ModuleThread.start();
    }
    public void linkThread(Thread thread) {
        ModuleThread = thread;
    }

    public Thread getModuleThread() {
        return ModuleThread;
    }

    public MirageServer getServer(){
        return Server;
    }
    
    abstract public String getName();
}
