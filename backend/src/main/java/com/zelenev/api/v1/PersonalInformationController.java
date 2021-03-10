package com.zelenev.api.v1;

import com.zelenev.data.dto.PersonalInformationDto;
import com.zelenev.services.PersonalInformationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/data"
)
@CrossOrigin("*")
public class PersonalInformationController {

    private final PersonalInformationService personalInformationService;

    public PersonalInformationController(PersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }

    @GetMapping(
            path = "/{login}"
    )
    public PersonalInformationDto read(@PathVariable String login) {
        return personalInformationService.readPersonalInformationByAccountLogin(login);
    }

    @PutMapping(
            path = "/{login}"
    )
    public void create(@PathVariable String login, @RequestBody PersonalInformationDto personalInformationDto) {
        personalInformationService.createPersonalInformationByAccountLogin(login, personalInformationDto);
    }

    @PatchMapping(
            path = "/{login}"
    )
    public void update(@PathVariable String login, PersonalInformationDto personalInformationDto) {

    }


}
