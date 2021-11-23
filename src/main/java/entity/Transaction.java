package entity;

import javax.persistence.*;

public class Transaction implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "source_card_id")
    Card sourceCard;

    @ManyToOne
    @JoinColumn(name = "destination_card_id")
    Card destinationCard;

    double amount;



    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id =id;
    }
}
