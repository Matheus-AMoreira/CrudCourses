package com.course.crudcourse.dto.mapper;

import com.course.crudcourse.dto.CourseDTO;
import com.course.crudcourse.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course){
        return new CourseDTO(course.getId(), course.getName(), course.getCategory());
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
        course.setCategory(courseDTO.category());
        course.setStatus("Ativo");
        return course;
    }
}
