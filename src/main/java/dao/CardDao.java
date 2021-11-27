package dao;

import entity.Account;
import entity.Card;
import entity.Transaction;

import javax.persistence.Query;
import java.util.Date;
import java.util.Optional;

public class CardDao extends BaseDao<Card,Long>{
    TransactionDao transactionDao = new TransactionDao();

    public Optional<Card> findByNumber(String number){
        Query query = entityManager.createQuery("select e from Card e where e.number = " + number);
        Card card=null;
        try{
            card =(Card) query.getSingleResult();
        }catch (Exception e){
            System.out.println("card not found");
        }

        return Optional.ofNullable( card);
    }

    @Override
    protected void setEntityClass() {
        this.entityClass=Card.class;
    }

    public void transfer(Card sourceCard, Card targetCard , double amount){
        Account source = sourceCard.getAccount();
        source.setBalance(source.getBalance()-amount - 600);
        Account target = targetCard.getAccount();
        target.setBalance(target.getBalance()+amount);
        saveOrUpdate(targetCard);
        saveOrUpdate(sourceCard);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(new Date());
        transaction.setDestinationCard(targetCard);
        transaction.setSourceCard(sourceCard);
        transactionDao.saveOrUpdate(transaction);
    }
}
