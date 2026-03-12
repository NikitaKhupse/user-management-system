package com.nikita.usermanagement.controller;

import com.nikita.usermanagement.entity.Task;
import com.nikita.usermanagement.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final TaskRepository taskRepository;

    public ManagerController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @PostMapping("/assign-task")
    public Task assignTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

}