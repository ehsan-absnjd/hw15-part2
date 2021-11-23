package entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Customer implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long nationalId;
    String firstName;
    String lastName;

    @OneToMany(mappedBy = "customer")
    List<Account> accounts;



    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long aLong) {

    }
}
