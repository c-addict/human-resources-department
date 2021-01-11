package com.zelenev.services;

import com.zelenev.data.dao.AccountRepository;
import com.zelenev.data.dao.RoleRepository;
import com.zelenev.data.dto.AuthenticationDto;
import com.zelenev.data.entities.Account;
import com.zelenev.data.entities.Role;
import com.zelenev.exceptions.AccountDoesNotExistException;
import com.zelenev.exceptions.InvalidPasswordException;
import com.zelenev.security.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final AccountRepository accountRepository;
    private final JwtProvider provider;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;

    public LoginService(AccountRepository accountRepository, JwtProvider provider, PasswordEncoder encoder, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.provider = provider;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
    }

    public AuthenticationDto login(Account account) {
        String login = account.getLogin();
        Optional<Account> foundAccount = accountRepository.findByLogin(login);
        if (foundAccount.isPresent()) {
            Account registeredAccount = foundAccount.get();
            String encodedPassword = encoder.encode(account.getPassword());
            if (encoder.matches(account.getPassword(), registeredAccount.getPassword())) {
                List<Role> accountRoles = roleRepository.findByAccountLogin(account.getLogin());
                String token = provider.generateToken(account.getLogin(), accountRoles);
                return new AuthenticationDto(token);
            } else
                throw new InvalidPasswordException("The password is invalid");
        } else
            throw new AccountDoesNotExistException("This login does not register");
    }
}
