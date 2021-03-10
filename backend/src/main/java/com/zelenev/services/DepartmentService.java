package com.zelenev.services;

import com.zelenev.data.dao.DepartmentRepository;
import com.zelenev.data.entities.Department;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department readOrCreateByTitle(String department) {
        Optional<Department> departmentOptional = departmentRepository.findByTitle(department);
        if (departmentOptional.isPresent()) {
            return departmentOptional.get();
        } else
            departmentRepository.save(new Department(department));
        return departmentRepository.findByTitle(department).get();
    }
}
