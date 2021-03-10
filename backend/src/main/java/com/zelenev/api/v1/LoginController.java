package com.zelenev.api.v1;

import com.zelenev.data.dto.AuthenticatedDto;
import com.zelenev.data.dto.AccountDto;
import com.zelenev.services.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/login"
)
@CrossOrigin("*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public AuthenticatedDto login(@RequestBody AccountDto accountDto) {
        String login = accountDto.getLogin();
        String password = accountDto.getPassword();
        return loginService.login(login, password);
    }
}
