package com.example.del;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProjectStartedEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // Выводим информацию о старте приложения
        System.out.println("Приложение запущено и доступно по адресу: http://localhost:8080");
    }
}
