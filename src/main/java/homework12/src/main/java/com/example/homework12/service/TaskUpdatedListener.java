package com.example.homework12.service;

import com.example.homework12.model.TaskUpdatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TaskUpdatedListener implements ApplicationListener<TaskUpdatedEvent> {
    @Override
    public void onApplicationEvent(TaskUpdatedEvent event) {
        String msg = "Было вызвано обновление статуса задачи: " + event.getTask().toString() +
                ". Время вызова: " + event.getTimestamp();
        System.out.println(msg);
    }
}
