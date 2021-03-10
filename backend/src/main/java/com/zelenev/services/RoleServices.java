package com.zelenev.services;

import com.zelenev.data.dao.RoleRepository;
import com.zelenev.data.entities.Role;
import com.zelenev.exceptions.RoleDoesNotExistException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServices {

    private final RoleRepository roleRepository;

    public RoleServices(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> readRolesByAccountLogin(String login) {
        return roleRepository.findByAccountLogin(login);
    }

    public Role readRoleByTitle(String title) {
        Optional<Role> roleOptional = roleRepository.findByTitle(title);
        if (roleOptional.isPresent())
            return roleOptional.get();
        else
            throw new RoleDoesNotExistException(String.format("Role %s does not exist", title));
    }
}
