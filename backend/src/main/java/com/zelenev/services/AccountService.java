package com.zelenev.services;

import com.zelenev.data.dao.AccountRepository;
import com.zelenev.data.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> readAll() {
        return this.accountRepository.findAll();
    }

    public Optional<Account> read(Integer id) {
        return this.accountRepository.findById(id);
    }

    public void create(Account account) {
        this.accountRepository.save(account);
    }
}