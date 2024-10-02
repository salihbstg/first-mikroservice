package com.bastug.user_service.service;

import com.bastug.user_service.feign.TaskFeignImlp;
import com.bastug.user_service.model.TaskDto;
import com.bastug.user_service.model.TaskWrapper;
import com.bastug.user_service.model.TaskWrapperResponse;
import com.bastug.user_service.model.User;
import com.bastug.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TaskFeignImlp taskFeignImlp;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<TaskDto> addTaskToUser(TaskDto taskDto) {
        ResponseEntity<TaskDto> task = taskFeignImlp.createTask(taskDto);
        User user=userRepository.findById(taskDto.getUserId()).orElse(null);
        if(user!=null) {
           user.getTasks().add(Objects.requireNonNull(task.getBody()).getTaskId());
           userRepository.save(user);
        }
        return task;
    }

    public User findById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public TaskWrapperResponse findTaskById(long taskId) {
         TaskWrapper taskWrapper = taskFeignImlp.getTask(taskId).getBody();
         TaskWrapperResponse taskWrapperResponse = new TaskWrapperResponse();
         taskWrapperResponse.setUser(findById(taskWrapper.getUserId()));
         taskWrapperResponse.setTitle(taskWrapper.getTitle());
         taskWrapperResponse.setDescription(taskWrapper.getDescription());
         taskWrapperResponse.setEndTime(taskWrapper.getEndTime());
         taskWrapperResponse.setStartTime(taskWrapper.getStartTime());
         return taskWrapperResponse;
    }
}
