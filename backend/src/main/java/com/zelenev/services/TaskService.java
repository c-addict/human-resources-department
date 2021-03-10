package com.zelenev.services;

import com.zelenev.data.dao.TaskRepository;
import com.zelenev.data.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> readTasksByAccountId(Integer id) {
        return taskRepository.readTasksByAccountId(id);
    }

    public void create(Task task) {
        taskRepository.save(task);
    }
}
