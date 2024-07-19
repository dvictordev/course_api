package com.victor.course_api.modules.course.useCases;

import com.victor.course_api.modules.course.entities.CourseEntity;
import com.victor.course_api.modules.course.exceptions.CourseNotFoundException;
import com.victor.course_api.modules.course.repositorie.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;


import java.util.Map;
import java.util.UUID;

@Service
public class UpdateCourse {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id,  Map<String, Object> requestBody) {
        requestBody.remove("active");

        System.out.println(requestBody);

        CourseEntity course = this.courseRepository.findById(id).orElseThrow(()-> {
            throw new CourseNotFoundException();
        });

        requestBody.forEach((key, value) -> {
        var field = ReflectionUtils.findField(CourseEntity.class, key);
        field.setAccessible(true);
        ReflectionUtils.setField(field, course, value);
        });

        return courseRepository.save(course);

    };
}
