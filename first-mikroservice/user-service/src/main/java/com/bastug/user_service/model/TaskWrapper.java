package com.bastug.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskWrapper {
    private String title;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private Long userId;
}
