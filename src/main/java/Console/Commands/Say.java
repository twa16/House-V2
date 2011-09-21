/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Console.Commands;

/**
 *
 * @author Manuel Gauto
 */
public class Say extends Command{

    @Override
    public boolean execute(String[] args) {
        if(args.length==3){
            RemoteSay.RemoteSay.say(args[1], args[2]);
            System.out.println("Remote Say Packet Sent To: "+args[1]+"\nContaining: "+args[2]);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String getName() {
        return "Say";
    }

    @Override
    public void printHelp() {
        System.out.println("    say -[host] -[message]");
    }
    
}
