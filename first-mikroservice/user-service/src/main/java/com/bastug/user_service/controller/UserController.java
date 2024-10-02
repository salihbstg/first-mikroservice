package com.bastug.user_service.controller;

import com.bastug.user_service.model.TaskDto;
import com.bastug.user_service.model.TaskWrapper;
import com.bastug.user_service.model.TaskWrapperResponse;
import com.bastug.user_service.model.User;
import com.bastug.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/task_to_user")
    public ResponseEntity<TaskDto> addTaskToUser(@RequestBody TaskDto taskDto) {
        return userService.addTaskToUser(taskDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(name = "userId") long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<TaskWrapperResponse> getTask(@PathVariable(name = "taskId") long taskId) {
        return ResponseEntity.ok(userService.findTaskById(taskId));
    }
}
