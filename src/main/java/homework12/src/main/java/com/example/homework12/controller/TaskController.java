package com.example.homework12.controller;

import com.example.homework12.model.Task;
import com.example.homework12.model.TaskStatus;
import com.example.homework12.service.FileGateway;
import com.example.homework12.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final FileGateway fileGateway;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        fileGateway.writeToFile(task.getDescription() + ".txt", task.toString());
        return taskService.addTask(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.findByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskStatus(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
