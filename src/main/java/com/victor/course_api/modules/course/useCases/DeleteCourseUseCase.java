package com.victor.course_api.modules.course.useCases;

import com.victor.course_api.modules.course.entities.CourseEntity;
import com.victor.course_api.modules.course.exceptions.CourseNotFoundException;
import com.victor.course_api.modules.course.repositorie.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;


    public String execute(UUID id){
        var course = this.courseRepository.findById(id).orElseThrow(() -> {
            throw new CourseNotFoundException();
        });

        this.courseRepository.deleteById(id);

        return "Curso deletado com sucesso";
    }
}
