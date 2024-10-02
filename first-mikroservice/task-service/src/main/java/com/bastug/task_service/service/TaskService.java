package com.bastug.task_service.service;

import com.bastug.task_service.model.Task;
import com.bastug.task_service.model.TaskDto;
import com.bastug.task_service.model.TaskWrapper;
import com.bastug.task_service.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskDto createTask(TaskDto taskDto) {
        System.out.println(taskDto);
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setTitle(taskDto.getTitle());
        task.setUserId(taskDto.getUserId());
        taskRepository.save(task);
        return taskDto;
    }

    public TaskWrapper getTask(Long id) {

        Task task = taskRepository.findById(id).orElse(null);

        if(task == null) {
            return null;
        }
        TaskWrapper taskWrapper = new TaskWrapper();
        taskWrapper.setDescription(task.getDescription());
        taskWrapper.setTitle(task.getTitle());
        taskWrapper.setUserId(task.getUserId());
        taskWrapper.setStartTime(task.getStartTime());
        taskWrapper.setEndTime(task.getEndTime());
        taskWrapper.setId(task.getId());
        return taskWrapper;
    }

    public List<TaskWrapper> getTasksByUserId(Long userId) {
        List<Task> task = taskRepository.findByUserId(userId);
        List<TaskWrapper> taskWrappers = new ArrayList<>();
        for (Task task1 : task) {
            TaskWrapper taskWrapper = new TaskWrapper();
            taskWrapper.setDescription(task1.getDescription());
            taskWrapper.setTitle(task1.getTitle());
            taskWrapper.setUserId(task1.getUserId());
            taskWrapper.setStartTime(task1.getStartTime());
            taskWrapper.setEndTime(task1.getEndTime());
            taskWrappers.add(taskWrapper);
        }
        return taskWrappers;
    }
}
