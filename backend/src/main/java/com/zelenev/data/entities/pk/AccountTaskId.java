package com.zelenev.data.entities.pk;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AccountTaskId implements Serializable {

    @Column(
            name = "account_id"
    )
    private Integer accountId;

    @Column(
            name = "task_id"
    )
    private Integer taskId;

    public AccountTaskId() {
    }

    public AccountTaskId(Integer accountId, Integer taskId) {
        this.accountId = accountId;
        this.taskId = taskId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTaskId that = (AccountTaskId) o;
        return accountId.equals(that.accountId) && taskId.equals(that.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, taskId);
    }
}
