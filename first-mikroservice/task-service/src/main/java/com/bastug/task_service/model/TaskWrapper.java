package com.bastug.task_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskWrapper {
    private Long id;
    private String title;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private Long userId;
}
