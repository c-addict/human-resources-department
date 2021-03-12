package com.zelenev.configuration;

import com.github.javafaker.Faker;
import com.zelenev.data.dao.*;
import com.zelenev.data.entities.*;
import com.zelenev.data.entities.pk.AccountRoleId;
import com.zelenev.services.CardService;
import com.zelenev.services.LoginService;
import com.zelenev.services.RegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class ApplicationConfiguration {

    @Bean
    Faker faker() {
        return new Faker();
    }

    @Bean
    CommandLineRunner commandLineRunner(Faker faker,
                                        RoleRepository roleRepository,
                                        AccountRepository accountRepository,
                                        RegistrationService registrationService,
                                        DepartmentRepository departmentRepository,
                                        PositionRepository positionRepository,
                                        CardService cardService,
                                        CardRepository cardRepository) {
        return args -> {

            Role userRole = new Role("ROLE_USER");
            Role adminRole = new Role("ROLE_ADMIN");

            roleRepository.saveAll(List.of(adminRole, userRole));

            //Admin test account creating
//            String login = "admin";
//            String password = "admin";
//            registrationService.registration(login, password);
//            Account adminAccount = accountRepository.findByLogin(login).get();
//            System.out.println(adminAccount);
//
//            String departmentTitle = "Software development";
//            departmentRepository.save(new Department(departmentTitle));
//            Department adminDepartment = departmentRepository.findByTitle(departmentTitle).get();
//            System.out.println(adminDepartment);
//
//            String positionTitle = "Senior backend developer";
//            positionRepository.save(new Position(positionTitle));
//            Position adminPosition = positionRepository.findByTitle(positionTitle).get();
//            System.out.println(adminPosition);
//
//            String firstName = "Nikolay";
//            String lastName = "Zelenev";
//            Date birthdayDate = faker.date().birthday();
//            String phone = "89507597752";
//            Integer salary = 250000;
//
//            cardRepository.save(new Card(
//                    adminAccount,
//                    firstName,
//                    lastName,
//                    birthdayDate,
//                    phone,
//                    salary,
//                    adminDepartment,
//                    adminPosition
//            ));
            };
    }
}
