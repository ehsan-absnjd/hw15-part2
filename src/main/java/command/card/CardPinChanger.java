package command.card;

import command.Command;
import entity.Card;
import service.CardService;
import util.Scanner;

import java.util.Optional;

public class CardPinChanger implements Command {
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
                break;
            }
            System.out.println("card id is not valid");
        }
        int faultCounter=0;
        System.out.println("enter old pin number");
        for (int i=0;i<3 ; i++){
            if (!scanner.getString().equals(card.getPin())){
                faultCounter++;
                System.out.println("pin is wrong, you have " +(3-faultCounter) + " tries left" );
            }else {
                break;
            }
        }
        if (faultCounter>=2){
            card.setActive(false);
            cardService.saveOrUpdate(card);
            return;
        }
        System.out.println("enter new pin number");
        card.setPin(scanner.getString());
        cardService.saveOrUpdate(card);

    }

    public CardPinChanger(CardService cardService) {
        this.cardService = cardService;
    }
}
