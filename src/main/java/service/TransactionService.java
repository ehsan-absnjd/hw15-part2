package service;

import dao.TransactionDao;
import entity.Transaction;

import java.util.Date;
import java.util.List;

public class TransactionService extends BaseService<Transaction,Long> {
    @Override
    protected void setDao() {
        this.dao = new TransactionDao();
    }
    public List<Transaction> getTransactionByCardNumberAfter(String cardNumber , Date date){
        return ((TransactionDao)dao).transactionsPerCustomerAfter(cardNumber, date);
    }
}
