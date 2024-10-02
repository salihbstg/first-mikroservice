package com.bastug.task_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private Long userId;
    private String title;
    private String description;
}
