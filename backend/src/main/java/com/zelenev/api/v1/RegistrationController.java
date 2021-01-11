package com.zelenev.api.v1;

import com.zelenev.data.dto.AccountRegistrationDto;
import com.zelenev.data.entities.Account;
import com.zelenev.services.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/registration"
)
public class RegistrationController {

    private final AccountService accountService;

    public RegistrationController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public void registration(@RequestBody AccountRegistrationDto accountDto) {
        Account newUserAccount = new Account();

        newUserAccount.setLogin(accountDto.getLogin());
        newUserAccount.setPassword(accountDto.getPassword());

        accountService.create(newUserAccount);
    }
}
