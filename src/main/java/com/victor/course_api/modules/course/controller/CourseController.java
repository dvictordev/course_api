package com.victor.course_api.modules.course.controller;

import com.victor.course_api.modules.course.dto.RequestDto;
import com.victor.course_api.modules.course.entities.CourseEntity;
import com.victor.course_api.modules.course.enums.ActiveEnum;
import com.victor.course_api.modules.course.useCases.CourseUseCase;
import com.victor.course_api.modules.course.useCases.FindAllCoursesUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseUseCase courseUseCase;

    @Autowired
    private FindAllCoursesUseCase findAllCoursesUseCase;

    @PostMapping()
    public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseEntity course) {
        course.setActive(ActiveEnum.ATIVO);
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
    public ResponseEntity<Object> updateCourse(@PathVariable String id, @RequestBody() RequestDto data ){
        return ResponseEntity.ok().body(data);
    };
}