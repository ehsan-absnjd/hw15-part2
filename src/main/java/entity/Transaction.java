package entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Transaction implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "source_card_id")
    private Card sourceCard;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_card_id")
    private Card destinationCard;

    private double amount;

    private Date date;

    public Transaction() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSourceCard(Card sourceCard) {
        this.sourceCard = sourceCard;
    }

    public void setDestinationCard(Card destinationCard) {
        this.destinationCard = destinationCard;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Card getSourceCard() {
        return sourceCard;
    }

    public Card getDestinationCard() {
        return destinationCard;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id =id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", sourceCard=" + sourceCard +
                ", destinationCard=" + destinationCard +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
