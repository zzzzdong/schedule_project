package com.example.schedule_project.dto;

import com.example.schedule_project.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

//일정 응답 데이터를 담는 DTO

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

}
