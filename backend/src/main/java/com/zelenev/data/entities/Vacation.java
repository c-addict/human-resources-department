package com.zelenev.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

@Entity(name = "Vacation")
@Table(
        name = "vacation",
        schema = "public"
)
public class Vacation implements Serializable {

    @Id
    @SequenceGenerator(
            name = "vacation_sequence",
            sequenceName = "vacation_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "vacation_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "vacation_to_account_id_fk"
            )
    )
    private Account account;

    @Column(
            name = "start_date",
            nullable = false
    )
    @Temporal(DATE)
    private Date startDate;

    @Column(
            name = "end_date",
            nullable = false
    )
    @Temporal(DATE)
    private Date endDate;

    public Vacation() {
    }

    public Vacation(Account account, Date startDate, Date endDate) {
        this.account = account;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Vacation(Integer id, Account account, Date startDate, Date endDate) {
        this.id = id;
        this.account = account;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return id.equals(vacation.id) && account.equals(vacation.account) && startDate.equals(vacation.startDate) && endDate.equals(vacation.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "id=" + id +
                ", account=" + account +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
