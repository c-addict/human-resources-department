package com.zelenev.services;

import com.zelenev.data.dao.AccountRepository;
import com.zelenev.data.dao.AccountRoleRepository;
import com.zelenev.data.dao.RoleRepository;
import com.zelenev.data.entities.Account;
import com.zelenev.data.entities.AccountRole;
import com.zelenev.data.entities.Role;
import com.zelenev.data.entities.pk.AccountRoleId;
import com.zelenev.exceptions.AccountAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AccountRoleRepository accountRoleRepository;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, AccountRoleRepository accountRoleRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.accountRoleRepository = accountRoleRepository;
    }

    public List<Account> readAll() {
        return this.accountRepository.findAll();
    }

    public Optional<Account> read(String login) {
        return this.accountRepository.findByLogin(login);
    }

    //TODO Fix that shit
    public void create(Account account) {
        Optional<Account> foundAccount = accountRepository.findByLogin(account.getLogin());
        if (foundAccount.isPresent())
            throw new AccountAlreadyExistsException("This email already registered");
        else {
            String encryptedPassword = passwordEncoder.encode(account.getPassword());
            account.setPassword(encryptedPassword);
            this.accountRepository.save(account);

            Account savedAccount = accountRepository.findByLogin(account.getLogin()).get();
            Role userRole = roleRepository.findByTitle("ROLE_USER").get();

            AccountRole accountRole = new AccountRole(
                    new AccountRoleId(savedAccount.getId(), userRole.getId()),
                    savedAccount,
                    userRole
            );
            accountRoleRepository.save(accountRole);
        }
    }
}
