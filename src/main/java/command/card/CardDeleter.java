package command.card;

import command.Command;
import entity.Card;
import service.CardService;
import util.Scanner;

import java.util.Optional;

public class CardDeleter implements Command {
    CardService cardService;
    Scanner scanner = new Scanner();
    @Override
    public void execute() {
        Card card=null;
        Long cardId ;
        while(true){
            System.out.println("enter card id, 0 for return");
            cardId=scanner.getLong();
            if (cardId==0){
                return;
            }
            Optional<Card> cardOptional = cardService.fincById(cardId);
            if (cardOptional.isPresent()){
                card =cardOptional.get();
                cardService.delete(card);
                break;
            }
            System.out.println("card id is not valid");
        }

    }

    public CardDeleter(CardService cardService) {
        this.cardService = cardService;
    }
}
