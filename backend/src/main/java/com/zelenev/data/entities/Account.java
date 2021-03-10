package com.zelenev.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Account")
@Table(
        name = "account",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_login",
                        columnNames = "login"
                )
        }
)
public class Account implements Serializable {

    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "account_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "login",
            nullable = false
    )
    private String login;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    @OneToOne(
            fetch = FetchType.EAGER,
            mappedBy = "account",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private Card card;


    @OneToMany(
            mappedBy = "account",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<AccountRole> accountRoles = new LinkedList<>();

    @OneToMany(
            mappedBy = "account",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Change> changes = new LinkedList<>();

    @OneToMany(
            mappedBy = "account",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Vacation> vacations = new LinkedList<>();

    @OneToMany(
            mappedBy = "account",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Task> tasks = new LinkedList<>();

    public Account() {
    }

    public Account(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Change> getChanges() {
        return changes;
    }

    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    public List<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(List<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }

    public void addTask(Task task) {
        if (!this.tasks.contains(task)) {
            this.tasks.add(task);
            task.setAccount(this);
        }
    }

    public void removeTask(Task task) {
        if (this.tasks.contains(task)) {
            this.tasks.remove(task);
            task.setAccount(null);
        }
    }

    public void addChange(Change change) {
        if (!this.changes.contains(change)) {
            this.changes.add(change);
            change.setAccount(this);
        }
    }

    public void removeChange(Change change) {
        if (this.changes.contains(change)) {
            this.changes.remove(change);
            change.setAccount(null);
        }
    }

    public void addVacation(Vacation vacation) {
        if (!this.vacations.contains(vacation)) {
            this.vacations.add(vacation);
            vacation.setAccount(this);
        }
    }

    public void addAccountRole(AccountRole accountRole) {
        if (!this.accountRoles.contains(accountRole)) {
            this.accountRoles.add(accountRole);
        }
    }

    public void removeAccountRole(AccountRole accountRole) {
        this.accountRoles.remove(accountRole);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id) &&
                login.equals(account.login) &&
                password.equals(account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
