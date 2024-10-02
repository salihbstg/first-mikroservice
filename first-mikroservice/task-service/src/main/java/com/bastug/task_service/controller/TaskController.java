package com.bastug.task_service.controller;

import com.bastug.task_service.model.Task;
import com.bastug.task_service.model.TaskDto;
import com.bastug.task_service.model.TaskWrapper;
import com.bastug.task_service.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskWrapper> getTask(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskWrapper>> getTasksByUserId(@PathVariable(name = "userId") Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }


}
