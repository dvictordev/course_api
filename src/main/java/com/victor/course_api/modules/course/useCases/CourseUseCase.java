package com.victor.course_api.modules.course.useCases;

import com.victor.course_api.modules.course.entities.CourseEntity;
import com.victor.course_api.modules.course.repositorie.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseUseCase {


    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity course){

       return this.courseRepository.save(course);

    }

}
