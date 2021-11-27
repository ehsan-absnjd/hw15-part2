package command;

import command.account.*;
import service.AccountService;
import util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class AccountMenu implements Command {
    Scanner scanner = new Scanner();
    private Map<Integer, Command> commandMap = new HashMap<>();
    AccountService accountService = new AccountService();

    @Override
    public void execute() {
        int command;
        do{
            System.out.println("1)show all accounts 2)add account 3)update account 4)delete account 5)show customer's accounts 6)back");
            command=scanner.getInt();
            if (command<6 && command>0){
                commandMap.get(command).execute();
            }else if (command==6){
                break;
            }else {
                System.out.println("invalid command, try again!");
            }
        }while (command!=6);
    }

    public AccountMenu() {
        commandMap.put(1,new AccountShower(accountService));
        commandMap.put(2, new AccountAdder(accountService));
        commandMap.put(3,new AccountUpdater(accountService));
        commandMap.put(4 , new AccountDeleter(accountService));
        commandMap.put(5, new CustomerAccountShower(accountService));
    }
}
