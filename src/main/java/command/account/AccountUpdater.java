package command.account;

import command.Command;
import entity.Account;
import entity.Branch;
import entity.Card;
import entity.Customer;
import service.AccountService;
import service.BranchService;
import service.CardService;
import service.CustomerService;
import util.Scanner;

import java.util.Optional;

public class AccountUpdater implements Command {
    AccountService accountService ;
    CustomerService customerService = new CustomerService();
    BranchService branchService = new BranchService();
    CardService cardService = new CardService();
    Scanner scanner =new Scanner();
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

//        Card card=null;
//        Long cardId ;
//        while(true){
//            System.out.println("enter card id, 0 for skip");
//            cardId=scanner.getLong();
//            if (cardId==0){
//                break;
//            }
//            Optional<Card> cardOptional = cardService.fincById(cardId);
//            if (cardOptional.isPresent()){
//                card =cardOptional.get();
//                break;
//            }
//            System.out.println("card id is not valid");
//        }
        System.out.println("enter balance");
        Double balance = scanner.getDouble();

        Long branchId ;
        Branch branch=null;
        while(true){
            System.out.println("enter branch id, 0 for skip");
            branchId=scanner.getLong();
            if (branchId==0){
                break;
            }
            Optional<Branch> branchOptional = branchService.fincById(branchId);
            if (branchOptional.isPresent()){
                branch=branchOptional.get();
                break;
            }
            System.out.println("branch id is not valid");
        }

        Long customerId ;
        Customer customer=null;
        while(true){
            System.out.println("enter customer id, 0 for skip");
            customerId=scanner.getLong();
            if (customerId==0){
                break;
            }
            Optional<Customer> customerOptional = customerService.fincById(customerId);
            if (customerOptional.isPresent()){
                customer=customerOptional.get();
                break;
            }
            System.out.println("customer id is not valid");
        }
        account.setBalance(balance);
        account.setCustomer(customer);
        //account.setCard(card);
        account.setBranch(branch);
        accountService.saveOrUpdate(account);

    }

    public AccountUpdater(AccountService accountService) {
        this.accountService = accountService;
    }
}
