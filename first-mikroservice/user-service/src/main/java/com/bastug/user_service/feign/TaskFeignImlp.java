package com.bastug.user_service.feign;

import com.bastug.user_service.model.TaskDto;
import com.bastug.user_service.model.TaskWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("TASK-SERVICE")
public interface TaskFeignImlp {
    @PostMapping("/task")
    ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task);
    @GetMapping("/task/{id}")
    ResponseEntity<TaskWrapper> getTask(@PathVariable(name = "id") Long id);
    @GetMapping("/task/user/{userId}")
    ResponseEntity<List<TaskWrapper>> getTasksByUserId(@PathVariable(name = "userId") Long userId);
}
