package com.example.schedule_project.dto;

import lombok.Getter;

//일정 생성 시 데이터를 담는 DTO

@Getter
public class ScheduleRequestDto {
    private final String username;
    private final String title;
    private final String content;

    public ScheduleRequestDto(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
