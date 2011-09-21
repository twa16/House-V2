/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StartUp;

import Console.Console;

/**
 *
 * @author Manuel Gauto
 */
public class Main {
    public static String Config_File="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Console c = new Console();
        Commands.addCommands(c);
        c.start();
        
        
    }
}
