package com.victor.course_api.modules.course.controller;

import com.victor.course_api.modules.course.entities.CourseEntity;
import com.victor.course_api.modules.course.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseUseCase courseUseCase;

    @Autowired
    private FindAllCoursesUseCase findAllCoursesUseCase;

    @Autowired
    private UpdateCourse updateCourse;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private ActiveOrInactiveCourse activeOrInactiveCourse;

    @PostMapping()
    public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseEntity course) {
        course.setActive(true);
        try{
            var result = this.courseUseCase.execute(course);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    };

    @GetMapping()
    public ResponseEntity<Object> findCourse(){
        var result = this.findAllCoursesUseCase.execute();

        return ResponseEntity.ok().body(result);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable String id, @RequestBody() Map<String, Object> requestBody ){
            var course = this.updateCourse.execute(UUID.fromString(id), requestBody);

            return ResponseEntity.ok().body(course);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable String id){
        var course = this.deleteCourseUseCase.execute(UUID.fromString(id));

        return ResponseEntity.ok(course);
    };

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> activeOrInactiveCourse(@PathVariable String id){
        var course = this.activeOrInactiveCourse.execute(UUID.fromString(id));

        return ResponseEntity.ok(course);
    };
}
