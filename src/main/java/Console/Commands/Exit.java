/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Console.Commands;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Gauto
 */
public class Exit extends Command{
    
    @Override
    public boolean execute(String[] args) {
        System.out.println("Exiting...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.exit(0);
        return true;
    }

    @Override
    public void printHelp() {
        System.out.println("Terminates the server process");
    }

    @Override
    public String getName() {
        return "Exit";
    }
    
}
