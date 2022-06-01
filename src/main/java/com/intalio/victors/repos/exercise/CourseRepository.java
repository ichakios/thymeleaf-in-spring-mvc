package com.intalio.victors.repos.exercise;

import com.intalio.victors.domain.exercise.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
