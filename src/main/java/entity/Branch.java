package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Branch implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "manager_id")
    Manager manager;

    @OneToMany(mappedBy = "branch")
    List<Employee> employees;

    @OneToMany(mappedBy = "branch")
    List<Account> accounts;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
