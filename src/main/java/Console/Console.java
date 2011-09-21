/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import Console.Commands.Command;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Manuel Gauto
 */
public class Console{

    Scanner sc=new Scanner(System.in);;
    Map<String, Command> TextCommandMap = new HashMap<String, Command>();    

    public Console(){
        
    }
    
    public void start(){
        read(sc);
    }

    public void addCommand(Command c) {
        String toadd=c.getName().toUpperCase();
        TextCommandMap.put(toadd, c);
        System.out.println("Command Added: "+toadd);
    }

    private void execute(Command c, String[] args) {
        boolean ok=c.execute(args);
        if(ok==false){
            c.printHelp();
        }
        read(sc);
    }

    private void checkCommand(String ca) {
        String c=ca.toUpperCase();
        String[] parts=c.split(" ");
        Command cmdoffer=TextCommandMap.get(parts[0]);
        if(cmdoffer==null){
            System.err.println("Command "+parts[0]+" Not Found!\n");
            read(sc);
        }
        else{
            String[] args=c.replace(" ", "").split("-");
            //ArrayList<String> partslist=Arrays.asList(args);
            //partslist.remove(parts[0]);
            //String[] temp = partslist.toArray(args);
            execute(cmdoffer, args);
        }
        
    }
    
    
    
    private void read(Scanner sc){
        System.out.print("$ ");
        String comd=sc.nextLine();
        checkCommand(comd);
    }
    
}
