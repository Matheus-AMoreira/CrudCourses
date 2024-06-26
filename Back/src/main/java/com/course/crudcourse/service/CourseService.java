package com.course.crudcourse.service;

import com.course.crudcourse.dto.CourseDTO;
import com.course.crudcourse.dto.mapper.CourseMapper;
import com.course.crudcourse.exception.RecordNotFoundException;
import com.course.crudcourse.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseService, CourseMapper courseMapper){
        this.courseRepository = courseService;
        this.courseMapper = courseMapper;
    }

    public List<CourseDTO> list() {
        return  courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO findById(@NotNull @Positive Long id){
        return  courseRepository.findById(id).map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public CourseDTO create(@Valid @NotNull CourseDTO course){
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public CourseDTO update(@NotNull @Positive Long id,
                                         @Valid @NotNull CourseDTO course){
        return  courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.name());
                    recordFound.setCategory(courseMapper.convertCategoryValue(course.category()));
                    return courseMapper.toDTO(courseRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        courseRepository.findById(id)
                .map(recordFound -> {
                    courseRepository.deleteById(id);
                    return  true;
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
