package command.card;

import command.Command;
import entity.Card;
import service.CardService;
import service.TransactionService;
import util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardTransactionShower implements Command {
    CardService cardService;
    TransactionService transactionService = new TransactionService();
    Scanner scanner = new Scanner();
    public CardTransactionShower(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        System.out.println("enter 4 digit year");
        String year = scanner.getString();
        System.out.println("enter 2 digit month");
        String month = scanner.getString();
        System.out.println("enter 2 digit day");
        String day = scanner.getString();
        String datestring = year+"/"+month+"/"+day;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null ;
        try {
            date = format.parse(datestring);
        } catch (ParseException e) {
            System.out.println("date is not valid");
            return;
        }
        System.out.println("enter card number");
        String cardNumber= scanner.getString();
        transactionService.getTransactionByCardNumberAfter(cardNumber,date).stream().forEach(System.out::println);


    }
}
