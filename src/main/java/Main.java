import command.MainMenu;
import dao.TransactionDao;
import entity.Account;
import entity.Card;
import entity.Customer;
import entity.Transaction;
import service.CardService;
import service.CustomerService;
import service.TransactionService;
import util.SingletonEntityManager;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        new MainMenu().execute();
    }
}
