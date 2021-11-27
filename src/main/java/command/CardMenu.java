package command;

import command.card.*;
import service.CardService;
import util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class CardMenu implements Command {
    Scanner scanner = new Scanner();
    private Map<Integer, Command> commandMap = new HashMap<>();
    CardService cardService = new CardService();
    @Override
    public void execute() {
        int command;
        do{
            System.out.println("1)show all cards 2)add card 3)update card 4)delete card 5)change pin 6)transfer 7)show card transactions 8)back ");
            command=scanner.getInt();
            if (command<8 && command>0){
                commandMap.get(command).execute();
            }else if (command==8){
                break;
            }else {
                System.out.println("invalid command, try again!");
            }
        }while (command!=8);
    }

    public CardMenu() {
        commandMap.put(1, new CardShower(cardService));
        commandMap.put(2 , new CardAdder(cardService));
        commandMap.put(3, new CardUpdater(cardService));
        commandMap.put(4 , new CardDeleter(cardService));
        commandMap.put(5 , new CardPinChanger(cardService));
        commandMap.put(6, new TransferCardToCard(cardService));
        commandMap.put(7 , new CardTransactionShower(cardService));
    }
}
