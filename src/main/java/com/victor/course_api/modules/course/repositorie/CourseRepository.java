package com.victor.course_api.modules.course.repositorie;

import com.victor.course_api.modules.course.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}
