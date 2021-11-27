package entity;


import org.hibernate.annotations.Cascade;


import javax.persistence.*;

@Entity
public class Card implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne(cascade = CascadeType.PERSIST )
    @JoinColumn(name = "account_id")
    private Account account;


    private String pin;
    private int cvv2;
    private String expireDate;
    private boolean isActive=true;

    public Card() {
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
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

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", account=" + (account!= null ?account.getId():" ") +
                ", pin='" + pin + '\'' +
                ", cvv2=" + cvv2 +
                ", expireDate='" + expireDate + '\'' +
                ", isActive=" + isActive +
                "}";
    }
}
