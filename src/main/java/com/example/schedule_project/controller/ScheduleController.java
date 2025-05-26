package com.example.schedule_project.controller;

import com.example.schedule_project.dto.ScheduleRequestDto;
import com.example.schedule_project.dto.ScheduleResponseDto;
import com.example.schedule_project.entity.Schedule;
import com.example.schedule_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Schedule created = scheduleService.createSchedule(requestDto);
        return new ScheduleResponseDto(created);

    }

    //일정 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id) {

      return scheduleService.getSchedule(id);
    }

    //일정 수정
    @PatchMapping("/{id}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
       return scheduleService.updateSchedule(id, requestDto);
    }

    //일정 삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id)  {
        scheduleService.deleteSchedule(id);
    }



}
