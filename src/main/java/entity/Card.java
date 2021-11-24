package entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Card implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "card")
    Account account;

    String pin;
    int cvv2;
    String expireDate;

    public Card() {
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Account getAccount() {
        return account;
    }

    public String getPin() {
        return pin;
    }

    public int getCvv2() {
        return cvv2;
    }

    public String getExpireDate() {
        return expireDate;
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
