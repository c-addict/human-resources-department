package com.zelenev.api.v1;

import com.zelenev.data.dto.AccountRegistrationDto;
import com.zelenev.data.dto.AuthenticationDto;
import com.zelenev.data.entities.Account;
import com.zelenev.services.AccountService;
import com.zelenev.services.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/login"
)
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public AuthenticationDto login(@RequestBody AccountRegistrationDto accountRegistrationDto) {
        Account account = new Account();

        String login = accountRegistrationDto.getLogin();
        String password = accountRegistrationDto.getPassword();

        account.setLogin(login);
        account.setPassword(password);

        return loginService.login(account);
    }
}
