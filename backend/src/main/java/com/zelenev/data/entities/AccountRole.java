package com.zelenev.data.entities;

import com.zelenev.data.entities.pk.AccountRoleId;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "AccountRole")
@Table(
        name = "account_role",
        schema = "public"
)
public class AccountRole {

    @EmbeddedId
    private AccountRoleId id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(
            name = "account_id"
    )
    private Account account;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(
            name = "role_id"
    )
    private Role role;

    public AccountRole() {
    }

    public AccountRole(Account account, Role role) {
        this.account = account;
        this.role = role;
    }

    public AccountRoleId getId() {
        return id;
    }

    public void setId(AccountRoleId id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRole that = (AccountRole) o;
        return id.equals(that.id) && account.equals(that.account) && role.equals(that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, role);
    }

    @Override
    public String toString() {
        return "AccountRole{" +
                "id=" + id +
                ", account=" + account +
                ", role=" + role +
                '}';
    }
}
