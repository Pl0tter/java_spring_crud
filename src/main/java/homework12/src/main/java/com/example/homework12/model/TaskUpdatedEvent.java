package com.example.homework12.model;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class TaskUpdatedEvent extends ApplicationEvent {
    private Task task;

    public TaskUpdatedEvent(Object source, Task task) {
        super(source);
        this.task = task;
    }
}
