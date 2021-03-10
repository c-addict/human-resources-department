package com.zelenev.services;

import com.zelenev.data.dto.AddressDto;
import com.zelenev.data.dto.PersonalInformationDto;
import com.zelenev.data.entities.*;
import com.zelenev.exceptions.CardDoesNotExistsException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationService {

    private final AccountService accountService;

    private final CardService cardService;

    private final DepartmentService departmentService;

    private final PositionService positionService;

    public PersonalInformationService(AccountService accountService,
                                      CardService cardService,
                                      DepartmentService departmentService,
                                      PositionService positionService) {
        this.accountService = accountService;
        this.cardService = cardService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    public void createPersonalInformationByAccountLogin(String login, PersonalInformationDto personalInformationDto) {
        Account account = accountService.readAccountByLogin(login).get();

        String firstName = personalInformationDto.getFirstName();
        String lastName = personalInformationDto.getLastName();
        Date birthdayDate = personalInformationDto.getBirthdayDate();
        String phone = personalInformationDto.getPhone();
        Integer salary = personalInformationDto.getSalary();

        Department department = departmentService.readOrCreateByTitle(personalInformationDto.getDepartment());
        Position position = positionService.readOrCreateByTitle(personalInformationDto.getPosition());

        Card card = new Card(
                account,
                firstName,
                lastName,
                birthdayDate,
                phone,
                salary,
                department,
                position
        );

        cardService.create(card);
        }

    public PersonalInformationDto readPersonalInformationByAccountLogin(String login) {
        Account account = accountService.readAccountByLogin(login).get();
        Optional<Card> cardOptional = cardService.readCardByAccountId(account.getId());
        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();

            List<AddressDto> addressDtos = new LinkedList<>();
            card.getAddresses().forEach((address) -> {
                AddressDto dto = new AddressDto(
                        address.getCountry(),
                        address.getCity(),
                        address.getStreet(),
                        address.getBuilding(),
                        address.getPostcode()
                );
                addressDtos.add(dto);
            });
            PersonalInformationDto dto = new PersonalInformationDto(
                    card.getFirstName(),
                    card.getLastName(),
                    card.getBirthdayDate(),
                    card.getPhone(),
                    card.getSalary(),
                    card.getDepartment().getTitle(),
                    card.getPosition().getTitle(),
                    addressDtos
            );
            return dto;
        } else
            throw new CardDoesNotExistsException("Card does not exists");
    }
}
