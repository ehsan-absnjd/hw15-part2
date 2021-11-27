package dao;

import entity.Transaction;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class TransactionDao extends BaseDao<Transaction,Long> {
    @Override
    protected void setEntityClass() {
        this.entityClass=Transaction.class;
    }
    public List<Transaction> transactionsPerCustomerAfter(String cardNumber, Date date){
        Query query = entityManager.createQuery("select t from Transaction t where (t.sourceCard.number = ?1 or t.destinationCard.number=?2) and t.date > ?3 " );
        query.setParameter(1,cardNumber);
        query.setParameter(2, cardNumber);
        query.setParameter(3, date);
        return query.getResultList();
    }
}
