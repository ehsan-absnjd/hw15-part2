package command.account;

import command.Command;
import entity.Account;
import service.AccountService;
import util.Scanner;

import java.util.Optional;

public class AccountDeleter implements Command {
    AccountService accountService;
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
                accountService.delete(account);
                break;
            }
            System.out.println("account id is not valid");
        }
    }

    public AccountDeleter(AccountService accountService) {
        this.accountService = accountService;
    }
}

