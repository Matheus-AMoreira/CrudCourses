package com.course.crudcourse.controller;

import java.util.List;

import com.course.crudcourse.dto.CourseDTO;
import com.course.crudcourse.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.course.crudcourse.model.Course;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> list() {
        return courseService.list();
    }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable @NotNull @Positive Long id){
        return  courseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public CourseDTO create(@RequestBody @Valid CourseDTO course){
        return courseService.create(course);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable @NotNull @Positive Long id,
                                         @RequestBody @Valid @NotNull CourseDTO course){
        return  courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        courseService.delete(id);
    }
}
