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

    @Column(
            name = "department_id",
            nullable = false
    )
    private Integer departmentId;

    @Column(
            name = "position_id",
            nullable = false
    )
    private Integer positionId;

    public Card() {
    }

    public Card(String firstName,
                String lastName,
                Date birthdayDate,
                String phone,
                Integer salary,
                Integer departmentId,
                Integer positionId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phone = phone;
        this.salary = salary;
        this.departmentId = departmentId;
        this.positionId = positionId;
    }

    public Card(Integer id,
                String firstName,
                String lastName,
                Date birthdayDate,
                String phone,
                Integer salary,
                Integer departmentId,
                Integer positionId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phone = phone;
        this.salary = salary;
        this.departmentId = departmentId;
        this.positionId = positionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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
        return id.equals(card.id) && firstName.equals(card.firstName) && lastName.equals(card.lastName) && birthdayDate.equals(card.birthdayDate) && phone.equals(card.phone) && salary.equals(card.salary) && departmentId.equals(card.departmentId) && positionId.equals(card.positionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthdayDate, phone, salary, departmentId, positionId);
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
                ", departmentId=" + departmentId +
                ", positionId=" + positionId +
                '}';
    }
}
