package com.bastug.user_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    @SequenceGenerator(name = "user_seq",sequenceName = "user_sequence",initialValue = 81247,allocationSize = 12)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @ElementCollection
    private List<Long> tasks=new ArrayList<>();
}
