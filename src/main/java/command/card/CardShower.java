package command.card;

import command.Command;
import service.CardService;
import util.Scanner;

public class CardShower implements Command {
    CardService cardService;
    Scanner scanner = new Scanner();
    @Override
    public void execute() {
        cardService.findAll().stream().forEach(System.out::println);

    }

    public CardShower(CardService cardService) {
        this.cardService = cardService;
    }
}
