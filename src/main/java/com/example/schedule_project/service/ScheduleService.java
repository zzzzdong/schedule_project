package com.example.schedule_project.service;

import com.example.schedule_project.dto.ScheduleRequestDto;
import com.example.schedule_project.dto.ScheduleResponseDto;
import com.example.schedule_project.entity.Schedule;
import com.example.schedule_project.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleRequestDto requestDto) {

        Schedule schedule = Schedule.builder()
                .username(requestDto.getUsername())
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .build();
        return scheduleRepository.save(schedule);

    }

    @Transactional
    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정이 없습니다. id = " + id));
        return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다. id=" + id));

        schedule.update(requestDto.getTitle(), requestDto.getContent());

        scheduleRepository.flush();

        Schedule updatedSchedule = scheduleRepository.findById(id).get();
        return new ScheduleResponseDto(updatedSchedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
