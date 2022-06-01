package com.intalio.victors.repos.exercise;

import com.intalio.victors.domain.exercise.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
