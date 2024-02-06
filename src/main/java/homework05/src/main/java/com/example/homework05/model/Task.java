package com.example.homework05.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private TaskStatus taskStatus;
    @Column(nullable = false)
    private LocalDateTime creationTime;

}
