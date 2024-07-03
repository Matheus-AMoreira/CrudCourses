package com.course.crudcourse.dto.mapper;

import com.course.crudcourse.dto.CourseDTO;
import com.course.crudcourse.dto.LessonDTO;
import com.course.crudcourse.enums.Category;
import com.course.crudcourse.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course){
        if (course == null){
            return null;
        }
        List<LessonDTO> lessons = course.getLessons().stream()
                .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl()))
                .collect(Collectors.toList());
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
    }

    public Course toEntity(CourseDTO courseDTO){

        if (courseDTO != null){
            return null;
        }

        Course course = new Course();
        if(courseDTO._id() != null){
            course.setId(courseDTO._id());
        }
        course.setName(courseDTO.name());
        course.setCategory(convertCategoryValue(courseDTO.category()));
        return course;
    }

    public Category convertCategoryValue(String value){
        if(value == null) {
            return null;
        }
        return switch (value){
            case "Front-end" -> Category.FRONTEND;
            case "Back-end" -> Category.BACKEND;
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };
    }
}
