package com.zelenev.services;

import com.zelenev.data.entities.Account;
import com.zelenev.data.entities.AccountRole;
import com.zelenev.data.entities.Role;
import com.zelenev.data.entities.pk.AccountRoleId;
import com.zelenev.data.mapper.mappers.AccountDtoToAccountMapper;
import com.zelenev.exceptions.AccountAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RegistrationService {

    private final AccountService accountService;

    private final RoleServices roleServices;

    private final AccountRoleService accountRoleService;

    private final PasswordEncoder encoder;

    public RegistrationService(AccountService accountService,
                               RoleServices roleServices,
                               AccountRoleService accountRoleService,
                               PasswordEncoder encoder) {
        this.accountService = accountService;
        this.roleServices = roleServices;
        this.accountRoleService = accountRoleService;
        this.encoder = encoder;
    }

    public void registration(String login, String password) {
        Optional<Account> accountOptional = accountService.readAccountByLogin(login);
        if (accountOptional.isEmpty()) {
            String encodedPassword = encoder.encode(password);
            Account account = new Account(login, encodedPassword);
            this.accountService.create(account);

            account = accountService.readAccountByLogin(login).get();
            Role userRole = roleServices.readRoleByTitle("ROLE_USER");
            accountRoleService.create(new AccountRole(
                    new AccountRoleId(account.getId(), userRole.getId()),
                    account,
                    userRole
            ));
        } else
            throw new AccountAlreadyExistsException(String.format("Login %s already registered.", login));
    }
}
