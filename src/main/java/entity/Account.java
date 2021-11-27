package entity;

import javax.persistence.*;

@Entity
public class Account implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne( cascade = CascadeType.ALL , orphanRemoval = true , mappedBy = "account")
    private Card card;

    private double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Branch branch;

    @ManyToOne(cascade = CascadeType.ALL )
    private Customer customer;


    public Account() {
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", card=" + card +
                ", balance=" + balance +
                ", branch=" + branch +
                ", customer=" + customer +
                '}';
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
