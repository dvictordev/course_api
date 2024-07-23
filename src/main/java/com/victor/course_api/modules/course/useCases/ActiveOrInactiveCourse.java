package com.victor.course_api.modules.course.useCases;

import com.victor.course_api.modules.course.entities.CourseEntity;
import com.victor.course_api.modules.course.exceptions.CourseNotFoundException;
import com.victor.course_api.modules.course.repositorie.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActiveOrInactiveCourse {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id){
        CourseEntity course = this.courseRepository.findById(id).orElseThrow(()-> {
            throw new CourseNotFoundException();
        });

        Boolean isActive = course.getActive();

        course.setActive(!isActive);

        return this.courseRepository.save(course);

    }
}
