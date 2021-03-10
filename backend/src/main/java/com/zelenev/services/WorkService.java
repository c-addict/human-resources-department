package com.zelenev.services;

import com.zelenev.data.dto.TaskDto;
import com.zelenev.data.dto.VacationDto;
import com.zelenev.data.entities.Account;
import com.zelenev.data.entities.Task;
import com.zelenev.data.entities.Vacation;
import com.zelenev.exceptions.AccountDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    private final AccountService accountService;

    private final TaskService taskService;

    private final VacationService vacationService;

    public WorkService(AccountService accountService, TaskService taskService, VacationService vacationService) {
        this.accountService = accountService;
        this.taskService = taskService;
        this.vacationService = vacationService;
    }

    public void createTaskByAccountLogin(String login, TaskDto taskDto) {
        Optional<Account> accountOptional = accountService.readAccountByLogin(login);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            Task task = new Task(
                    account,
                    taskDto.getTitle(),
                    taskDto.getDescription(),
                    taskDto.getDeadline()
            );
            taskService.create(task);
            account.addTask(task);
        }
    }

    public List<TaskDto> readTasksByAccountLogin(String login) {
        Optional<Account> accountOptional = accountService.readAccountByLogin(login);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            List<Task> tasks = taskService.readTasksByAccountId(account.getId());
            List<TaskDto> taskDtos = new LinkedList<>();
            tasks.forEach((task -> {
                taskDtos.add(new TaskDto(
                        task.getTitle(),
                        task.getDescription(),
                        task.getDeadline()
                ));
            }));
            return taskDtos;
        }
        throw new AccountDoesNotExistException("Account does not exists");
    }

    public List<VacationDto> readVacationsByAccountLogin(String login) {
        Optional<Account> accountOptional = accountService.readAccountByLogin(login);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            List<Vacation> vacations = vacationService.readVacationsByAccountId(account.getId());
            List<VacationDto> vacationDtos = new LinkedList<>();
            vacations.forEach((vacation -> {
                vacationDtos.add(new VacationDto(
                        vacation.getStartDate(),
                        vacation.getEndDate()
                ));
            }));
            return vacationDtos;
        } else
            throw new AccountDoesNotExistException("Account does not exists");
    }

    public void createVacationByAccountLogin(String login, VacationDto vacationDto) {
        Optional<Account> accountOptional = accountService.readAccountByLogin(login);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            Vacation vacation = new Vacation(
                    account,
                    vacationDto.getStartDate(),
                    vacationDto.getEndDate()
            );
            vacationService.create(vacation);
            account.addVacation(vacation);
        } else
            throw new AccountDoesNotExistException("Account does not exists");
    }
}
