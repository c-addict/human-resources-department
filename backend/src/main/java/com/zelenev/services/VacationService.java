package com.zelenev.services;

import com.zelenev.data.dao.VacationRepository;
import com.zelenev.data.entities.Vacation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService {

    private final VacationRepository vacationRepository;

    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    public List<Vacation> readVacationsByAccountId(Integer id) {
        return vacationRepository.findVacationsByAccountId(id);
    }

    public void create(Vacation vacation) {
        this.vacationRepository.save(vacation);
    }
}
