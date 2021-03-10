package com.zelenev.data.dao;

import com.zelenev.data.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {


    public List<Task> readTasksByAccountId(Integer id);
}
