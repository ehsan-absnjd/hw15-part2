package command.card;

import command.Command;
import entity.Card;
import service.CardService;
import util.Scanner;

import java.util.Optional;

public class TransferCardToCard implements Command {
    CardService cardService;
    Scanner scanner = new Scanner();
    @Override
    public void execute() {
        Card sourceCard=null;
        String cardNumber ;
        while(true){
            System.out.println("enter source card number, 0 for return");
            cardNumber=scanner.getString();
            if (cardNumber.equals("0")){
                return;
            }
            Optional<Card> cardOptional = cardService.findByNumber(  cardNumber);
            if (cardOptional.isPresent()){
                sourceCard =cardOptional.get();
                break;
            }
            System.out.println("card number is not valid");
        }

        Card targetCard=null;
        while(true){
            System.out.println("enter destination card number, 0 for return");
            cardNumber=scanner.getString();
            if (cardNumber.equals("0")){
                return;
            }
            Optional<Card> cardOptional = cardService.findByNumber(cardNumber);
            if (cardOptional.isPresent()){
                targetCard =cardOptional.get();
                break;
            }
            System.out.println("card number is not valid");
        }

        if (!isValid(sourceCard) ||  !isValid(targetCard)){
            return;
        }
        System.out.println("enter amount");
        double amount = scanner.getDouble();

        int faultCounter =0;
        for (int i=0;i<3 ; i++){
            System.out.println("enter pin");
            if (!scanner.getString().equals(sourceCard.getPin())){
                faultCounter++;
                System.out.println("pin is wrong, you have " +(3-faultCounter) + " tries left" );
            }else {
                break;
            }
        }
        if (faultCounter>=2){
            sourceCard.setActive(false);
            cardService.saveOrUpdate(sourceCard);
            return;
        }
        if(sourceCard.getAccount().getBalance()>=amount+6000){
            cardService.transfer(sourceCard,targetCard,amount);
        }else {
            System.out.println("credit is not enough");
        }
    }
    private boolean isValid(Card card){
        if (!card.isActive()){
            System.out.println("card " + card.getNumber()+" is not active");
            return false;
        }
        if (card.getAccount()==null){
            System.out.println("card "+ card.getNumber()+ " doesn't belong to an account");
            return false;
        }
        return true;

    }

    public TransferCardToCard(CardService cardService) {
        this.cardService = cardService;
    }
}
