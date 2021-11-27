package command.account;

import command.Command;
import entity.Account;
import entity.Customer;
import service.AccountService;
import service.CustomerService;
import util.Scanner;

import java.util.Optional;


public class CustomerAccountShower implements Command {
    Scanner scanner = new Scanner();
    AccountService accountService;
    CustomerService customerService = new CustomerService();
    @Override
    public void execute() {
        Customer customer=null;
        Long customerId ;
        while(true){
            System.out.println("enter customer id, 0 for return");
            customerId=scanner.getLong();
            if (customerId==0){
                return;
            }
            Optional<Customer> customerOptional = customerService.fincById(customerId);
            if (customerOptional.isPresent()){
                customer =customerOptional.get();
                break;
            }
            System.out.println("customer id is not valid");
        }
        customer.getAccounts().stream().forEach(System.out::println);

    }

    public CustomerAccountShower(AccountService accountService) {
        this.accountService = accountService;
    }
}
