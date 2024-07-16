package com.victor.course_api.modules.course.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.victor.course_api.modules.course.enums.ActiveEnum;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = "\\S+", message = "O campo [name] não deve conter espaço.")
    private String name;

    private String category;

    private ActiveEnum Active;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
