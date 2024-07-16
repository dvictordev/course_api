package com.victor.course_api.modules.course.useCases;

import com.victor.course_api.modules.course.entities.CourseEntity;
import com.victor.course_api.modules.course.repositorie.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCoursesUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(){

        return this.courseRepository.findAll();

    };
}
