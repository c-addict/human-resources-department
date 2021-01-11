package com.zelenev.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

@Entity(name = "Card")
@Table(
        name = "card",
        schema = "public"
)
public class Card implements Serializable {

    @Id
    @SequenceGenerator(
            name = "card_sequence",
            sequenceName = "card_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "card_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "card_id_account_id_fk"
            )
    )
    private Account account;

    @Column(
            name = "first_name",
            nullable = false,
            length = 50
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            length = 50
    )
    private String lastName;

    @Column(
            name = "birthday_date",
            nullable = false
    )
    @Temporal(DATE)
    private Date birthdayDate;

    @Column(
            name = "phone",
            nullable = false,
            length = 12
    )
    private String phone;

    @Column(
            name = "salary",
            nullable = false
    )
    private Integer salary;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "card_department_id_fk"
            )
    )
    private Department department;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "position_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "card_position_id_fk"
            )
    )
    private Position position;

    @OneToMany(
            mappedBy = "card",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Address> addresses = new LinkedList<>();

    @OneToMany(
            mappedBy = "card",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Education> educations = new LinkedList<>();

    public Card() {
    }

    public Card(Account account,
                String firstName,
                String lastName,
                Date birthdayDate,
                String phone,
                Integer salary,
                Department department,
                Position position) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    public Card(Integer id,
                Account account,
                String firstName,
                String lastName,
                Date birthdayDate,
                String phone,
                Integer salary,
                Department department,
                Position position) {
        this.id = id;
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public void addAddress(Address address) {
        if (!this.addresses.contains(address)) {
            this.addresses.add(address);
            address.setCard(this);
        }
    }

    public void removeAddress(Address address) {
        if (this.addresses.contains(address)) {
            this.addresses.remove(address);
            address.setCard(null);
        }
    }

    public void addEducation(Education education) {
        if (!this.educations.contains(education)) {
            this.educations.add(education);
            education.setCard(this);
        }
    }

    public void removeEducation(Education education) {
        if (this.educations.contains(education)) {
            this.educations.remove(education);
            education.setCard(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id.equals(card.id) && firstName.equals(card.firstName) && lastName.equals(card.lastName) && birthdayDate.equals(card.birthdayDate) && phone.equals(card.phone) && salary.equals(card.salary) && department.equals(card.department) && position.equals(card.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthdayDate, phone, salary, department, position);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdayDate=" + birthdayDate +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", departmentId=" + department +
                ", positionId=" + position +
                '}';
    }
}
