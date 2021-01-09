package com.zelenev.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Account")
public class Account implements Serializable {

    @Id
    private Integer id;

    private String login;

    private String password;

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
