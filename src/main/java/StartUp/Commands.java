/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StartUp;

import Console.Commands.Exit;
import Console.Commands.Say;
import Console.Commands.Test;
import Console.Console;

/**
 *
 * @author manuel
 */
public class Commands {
    public static void addCommands(Console c){
        c.addCommand(new Test());
        c.addCommand(new Exit());
        c.addCommand(new Say());
    }
}
