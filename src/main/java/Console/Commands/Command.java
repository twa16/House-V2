/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Console.Commands;

/**
 *
 * @author Manuel Gauto
 */
public abstract class Command {
    /**
     * Code to be executed when Command is called
     */
    abstract public boolean execute(String[] args);
    /**
     * Returns name of command. This is
     * the text that has to be typed for
     * the command to be executed.
     * @return Name of command
     */
    abstract public String getName();
    abstract public void printHelp();
    
}
