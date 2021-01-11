package com.zelenev.api.v1;

import com.zelenev.data.dto.AccountRegistrationDto;
import com.zelenev.data.entities.Account;
import com.zelenev.services.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/registration"
)
@CrossOrigin("*")
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
