package com.zelenev.api.v1;

import com.zelenev.data.dto.AccountDto;
import com.zelenev.services.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/registration"
)
@CrossOrigin("*")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public void registration(@RequestBody AccountDto accountDto) {
        String login = accountDto.getLogin();
        String password = accountDto.getPassword();
        registrationService.registration(login, password);
    }
}
