package com.bastug.task_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
public class Task {

    public Task(){
        startTime=LocalDate.now();
        endTime=startTime.plusDays(7);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "task_seq")
    @SequenceGenerator(name="task_seq",sequenceName = "task_sequence",initialValue = 4215632,allocationSize=47)
    private Long id;

    private String title;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private Long userId;
}
