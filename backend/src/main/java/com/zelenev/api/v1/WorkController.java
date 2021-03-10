package com.zelenev.api.v1;

import com.zelenev.data.dto.TaskDto;
import com.zelenev.data.dto.VacationDto;
import com.zelenev.services.WorkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/work"
)
@CrossOrigin("*")
public class WorkController {

    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping(
            path = "/task/{login}"
    )
    public List<TaskDto> readTasks(@PathVariable String login) {
        return workService.readTasksByAccountLogin(login);
    }

    @PutMapping(
            path = "/task/{login}"
    )
    public void createTask(@PathVariable String login, @RequestBody TaskDto taskDto) {
        workService.createTaskByAccountLogin(login, taskDto);
    }

    @GetMapping(
            path = "/vacation/{login}"
    )
    public List<VacationDto> getVacations(@PathVariable String login) {
        return workService.readVacationsByAccountLogin(login);
    }

    @PutMapping(
            path = "/vacation/{login}"
    )
    public void createVacation(@PathVariable String login, @RequestBody VacationDto vacationDto) {
        workService.createVacationByAccountLogin(login, vacationDto);
    }

}
