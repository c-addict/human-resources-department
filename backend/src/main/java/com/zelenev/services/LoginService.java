package com.zelenev.services;

import com.zelenev.data.dto.AuthenticatedDto;
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

    private final AccountService accountService;

    private final RoleServices roleServices;

    private final PasswordEncoder encoder;

    private final JwtProvider provider;

    public LoginService(AccountService accountService,
                        RoleServices roleServices,
                        PasswordEncoder encoder,
                        JwtProvider provider) {
        this.accountService = accountService;
        this.roleServices = roleServices;
        this.encoder = encoder;
        this.provider = provider;
    }

    public AuthenticatedDto login(String login, String password) {
        Optional<Account> registeredAccountOptional = accountService.readAccountByLogin(login);
        if (registeredAccountOptional.isPresent()) {
            Account registeredAccount = registeredAccountOptional.get();
            if (encoder.matches(password, registeredAccount.getPassword())) {
                List<Role> roles = roleServices.readRolesByAccountLogin(login);
                String token = provider.generateToken(login, roles);
                return new AuthenticatedDto(login, token);
            } else
                throw new InvalidPasswordException("Invalid password");
        } else
            throw new AccountDoesNotExistException(String.format("Login %s does not registered.", login));
    }

}
