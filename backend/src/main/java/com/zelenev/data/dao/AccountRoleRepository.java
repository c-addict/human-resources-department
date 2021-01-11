package com.zelenev.data.dao;

import com.zelenev.data.entities.AccountRole;
import com.zelenev.data.entities.pk.AccountRoleId;
import org.springframework.data.repository.CrudRepository;

public interface AccountRoleRepository extends CrudRepository<AccountRole, AccountRoleId> {
}
