package com.zelenev.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

@Entity(name = "Change")
@Table(
        name = "change",
        schema = "public"
)
public class Change implements Serializable {

    @Id
    @SequenceGenerator(
            name = "change_sequence",
            sequenceName = "change_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "change_sequence"
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
                    name = "change_to_account_fk"
            )
    )
    private Account account;

    @Column(
            name = "parameter",
            nullable = false,
            length = 25
    )
    private String parameter;

    @Column(
            name = "field",
            nullable = false,
            length = 25
    )
    private String field;

    @Column(
            name = "value",
            nullable = false
    )
    private String value;

    @Column(
            name = "date",
            nullable = false
    )
    @Temporal(DATE)
    private Date date;

    public Change() {
    }

    public Change(Account account, String parameter, String field, String value, Date date) {
        this.account = account;
        this.parameter = parameter;
        this.field = field;
        this.value = value;
        this.date = date;
    }

    public Change(Integer id, Account account, String parameter, String field, String value, Date date) {
        this.id = id;
        this.account = account;
        this.parameter = parameter;
        this.field = field;
        this.value = value;
        this.date = date;
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

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Change change = (Change) o;
        return id.equals(change.id) && account.equals(change.account) && parameter.equals(change.parameter) && field.equals(change.field) && value.equals(change.value) && date.equals(change.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, parameter, field, value, date);
    }

    @Override
    public String toString() {
        return "Change{" +
                "id=" + id +
                ", account=" + account +
                ", parameter='" + parameter + '\'' +
                ", field='" + field + '\'' +
                ", value='" + value + '\'' +
                ", date=" + date +
                '}';
    }
}
