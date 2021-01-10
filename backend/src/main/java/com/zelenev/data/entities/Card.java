package com.zelenev.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    @Column(
            name = "position_id",
            nullable = false
    )
    private Integer positionId;

    public Card() {
    }

    public Card(Account account,
                String firstName,
                String lastName,
                Date birthdayDate,
                String phone,
                Integer salary,
                Department department,
                Integer positionId) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
        this.positionId = positionId;
    }

    public Card(Integer id,
                Account account,
                String firstName,
                String lastName,
                Date birthdayDate,
                String phone,
                Integer salary,
                Department department,
                Integer positionId) {
        this.id = id;
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
        this.positionId = positionId;
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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id.equals(card.id) && firstName.equals(card.firstName) && lastName.equals(card.lastName) && birthdayDate.equals(card.birthdayDate) && phone.equals(card.phone) && salary.equals(card.salary) && department.equals(card.department) && positionId.equals(card.positionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthdayDate, phone, salary, department, positionId);
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
                ", positionId=" + positionId +
                '}';
    }
}
