package com.course.crudcourse.service;

import com.course.crudcourse.exception.RecordNotFoundException;
import com.course.crudcourse.model.Course;
import com.course.crudcourse.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseService){
        this.courseRepository = courseService;
    }

    public List<Course> list() {
        return courseRepository.findAll();
    }

    public Course findById(@PathVariable @NotNull @Positive Long id){
        return  courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Course create(@Valid Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> update(@NotNull @Positive Long id,
                                         @Valid Course course){
        return  courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    return courseRepository.save(recordFound);
                });
    }

    public void delete(@PathVariable @NotNull @Positive Long id){
        courseRepository.findById(id)
                .map(recordFound -> {
                    courseRepository.deleteById(id);
                    return  true;
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
