package entity;

import javax.persistence.*;

@Entity
public class Manager implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Long nationalId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public Manager() {
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
        this.id=id;
    }
}
