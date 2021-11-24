package entity;

import javax.persistence.*;

@Entity
public class Employee implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;
    Long nationalId;

    @ManyToOne
    Branch branch;

    public Employee() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public Branch getBranch() {
        return branch;
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
