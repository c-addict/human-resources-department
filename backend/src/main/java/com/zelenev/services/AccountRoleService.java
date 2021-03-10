package com.zelenev.services;

import com.zelenev.data.dao.AccountRoleRepository;
import com.zelenev.data.entities.AccountRole;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleService {

    private final AccountRoleRepository accountRoleRepository;

    public AccountRoleService(AccountRoleRepository accountRoleRepository) {
        this.accountRoleRepository = accountRoleRepository;
    }

    public void create(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }
}
