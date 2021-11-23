package entity;

import javax.persistence.*;

@Entity
public class Account implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "card_id")
    Card card;
    double balance;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    Branch branch;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
