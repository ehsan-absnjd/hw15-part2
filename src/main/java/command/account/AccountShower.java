package command.account;

import command.Command;
import service.AccountService;

public class AccountShower implements Command {
    AccountService accountService;
    @Override
    public void execute() {
        accountService.findAll().stream().forEach(System.out::println);

    }

    public AccountShower(AccountService accountService) {
        this.accountService = accountService;
    }
}
