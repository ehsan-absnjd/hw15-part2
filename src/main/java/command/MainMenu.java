package command;

import util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements Command {
    Scanner scanner = new Scanner();
    Map<Integer, Command> commandMap = new HashMap<>();
    @Override
    public void execute() {
        int command;
        do{
            System.out.println("1)card operations 2)account operations 3)exit");
            command=scanner.getInt();
            if (command<3 && command>0){
                commandMap.get(command).execute();
            }else if (command==3){
                System.out.println("bye!");
                break;
            }else {
                System.out.println("invalid command, try again!");
            }
        }while (command!=3);
    }
    public MainMenu(){
        commandMap.put(1 , new CardMenu());
        commandMap.put(2 , new AccountMenu());
    }
}
