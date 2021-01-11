package com.zelenev.data.entities;

import com.zelenev.data.entities.pk.AccountTaskId;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "AccountTask")
@Table(
        name = "account_task",
        schema = "public"
)
public class AccountTask {

    @EmbeddedId
    private AccountTaskId id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(
            name = "account_id"
    )
    private Account account;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(
            name = "task_id"
    )
    private Task task;

    public AccountTask() {
    }

    public AccountTask(Account account, Task task) {
        this.account = account;
        this.task = task;
    }

    public AccountTaskId getId() {
        return id;
    }

    public void setId(AccountTaskId id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTask that = (AccountTask) o;
        return id.equals(that.id) && account.equals(that.account) && task.equals(that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, task);
    }

    @Override
    public String toString() {
        return "AccountTask{" +
                "id=" + id +
                ", account=" + account +
                ", task=" + task +
                '}';
    }
}
