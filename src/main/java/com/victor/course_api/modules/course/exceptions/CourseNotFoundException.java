package com.victor.course_api.modules.course.exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(){
        super("Curso não encontrado!");
    }
}
