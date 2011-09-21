/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Console.Commands;

/**
 *
 * @author Manuel Gauto
 */
public class Test extends Command{

    @Override
    public boolean execute(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(i+": "+args[i]);
        }
        return true;
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public void printHelp() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
