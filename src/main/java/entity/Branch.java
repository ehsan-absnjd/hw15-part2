package entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Branch implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String location;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "branch")
    Manager manager;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    List<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    List<Account> accounts;


    public Branch() {
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getLocation() {
        return location;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
