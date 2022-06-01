package com.intalio.victors.service.exercise;

import com.intalio.victors.domain.exercise.Course;
import com.intalio.victors.domain.exercise.Student;
import com.intalio.victors.model.exercise.CourseDTO;
import com.intalio.victors.repos.exercise.CourseRepository;
import com.intalio.victors.repos.exercise.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseService(final CourseRepository courseRepository,
            final StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<CourseDTO> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(course -> mapToDTO(course, new CourseDTO()))
                .collect(Collectors.toList());
    }

    public CourseDTO get(final Long id) {
        return courseRepository.findById(id)
                .map(course -> mapToDTO(course, new CourseDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CourseDTO courseDTO) {
        final Course course = new Course();
        mapToEntity(courseDTO, course);
        return courseRepository.save(course).getId();
    }

    public void update(final Long id, final CourseDTO courseDTO) {
        final Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(courseDTO, course);
        courseRepository.save(course);
    }

    public void delete(final Long id) {
        courseRepository.deleteById(id);
    }

    private CourseDTO mapToDTO(final Course course, final CourseDTO courseDTO) {
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setSteps(course.getSteps());
        courseDTO.setStudent(course.getStudent() == null ? null : course.getStudent().getId());
        return courseDTO;
    }

    private Course mapToEntity(final CourseDTO courseDTO, final Course course) {
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setSteps(courseDTO.getSteps());
        if (courseDTO.getStudent() != null && (course.getStudent() == null || !course.getStudent().getId().equals(courseDTO.getStudent()))) {
            final Student student = studentRepository.findById(courseDTO.getStudent())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found"));
            course.setStudent(student);
        }
        return course;
    }

}
