package entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Account implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id" )
    Card card;
    double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    Branch branch;

    @ManyToOne(cascade = CascadeType.ALL)
    Customer customer;


    public Account() {
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Card getCard() {
        return card;
    }

    public double getBalance() {
        return balance;
    }

    public Branch getBranch() {
        return branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
