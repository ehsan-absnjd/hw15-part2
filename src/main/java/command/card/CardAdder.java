package command.card;

import command.Command;
import entity.Account;
import entity.Card;
import service.AccountService;
import service.CardService;
import util.Scanner;

import java.math.BigDecimal;
import java.util.Optional;

public class CardAdder implements Command {
    CardService cardService;
    AccountService accountService = new AccountService();
    Scanner scanner = new Scanner();
    @Override
    public void execute() {
        Account account=null;
        Long accountId ;
        while(true){
            System.out.println("enter account id, 0 for return");
            accountId=scanner.getLong();
            if (accountId==0){
                return;
            }
            Optional<Account> accountOptional = accountService.fincById(accountId);
            if (accountOptional.isPresent()){
                account =accountOptional.get();
                break;
            }
            System.out.println("account id is not valid");
        }

        String number;
        do{
            try {
                System.out.println("enter number");
                number = scanner.getString();
                Long.valueOf(number);
                if (number.length()==12 || number.length()==16 ){
                    break;
                }else {
                    System.out.println(223);
                    throw new Exception();
                }
            }catch (Exception e) {
                System.out.println("card number must be 12 or 16 digits");
            }
        }while (true);


        System.out.println("enter pin");
        String pin = scanner.getString();

        System.out.println("enter cvv2");
        int cvv2 = scanner.getInt();

        System.out.println("enter expire date");
        String expireDate = scanner.getString();

        Card card = new Card();
        card.setNumber(number);
        card.setAccount(account);
        card.setCvv2(cvv2);
        card.setExpireDate(expireDate);
        card.setPin(pin);
        cardService.saveOrUpdate(card);
    }

    public CardAdder(CardService cardService) {
        this.cardService = cardService;
    }
}
