package com.likelion12.workout.dto;

import java.time.LocalDateTime;

public class WorkoutOutput {
    public Long id;
    public String exerciseName;
    public Integer duration;
    public LocalDateTime date;
    public String content;

    public WorkoutOutput(Long id, String exerciseName, Integer duration, LocalDateTime date, String content) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.duration = duration;
        this.date = date;
        this.content = content;
    }
}
