package com.zelenev.configuration;

import com.github.javafaker.Faker;
import com.zelenev.data.dao.AccountRepository;
import com.zelenev.data.dao.AccountRoleRepository;
import com.zelenev.data.dao.RoleRepository;
import com.zelenev.data.entities.Account;
import com.zelenev.data.entities.AccountRole;
import com.zelenev.data.entities.Role;
import com.zelenev.data.entities.pk.AccountRoleId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApplicationConfiguration {

    @Bean
    Faker faker() {
        return new Faker();
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository, AccountRepository accountRepository, AccountRoleRepository accountRoleRepository) {
        return args -> {

            Role userRole = new Role("ROLE_USER");
            Role adminRole = new Role("ROLE_ADMIN");

            roleRepository.saveAll(List.of(adminRole, userRole));
        };
    }
}
