package service;

import dao.CardDao;
import entity.Card;

import java.util.Optional;

public class CardService extends BaseService<Card,Long>{
    @Override
    protected void setDao() {
        this.dao=new CardDao();
    }
    public void transfer(Card source, Card destination, double amount){
        dao.getTransaction().begin();
        ((CardDao)dao).transfer(source,destination, amount);
        dao.getTransaction().commit();
    }

    public Optional<Card> findByNumber(String number){
        return ((CardDao)dao).findByNumber(number);
    }
}
