package com.likelion12.workout.controller;

import com.likelion12.workout.dto.WorkoutInput;
import com.likelion12.workout.dto.WorkoutOutput;
import com.likelion12.workout.service.WorkoutService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutLog")
@CrossOrigin(origins="*")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @PostMapping()
    public ResponseEntity<WorkoutOutput> create(@RequestBody WorkoutInput workoutInput){
        if(workoutInput.getExerciseName() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        WorkoutOutput result = workoutService.create(workoutInput);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<WorkoutOutput>> findAll(){
        return new ResponseEntity<>(workoutService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutOutput> update(@PathVariable(value="id") Long id, @RequestBody WorkoutInput workoutInput){
        if(workoutInput.getExerciseName() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        WorkoutOutput result = workoutService.update(id, workoutInput);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){
        workoutService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
