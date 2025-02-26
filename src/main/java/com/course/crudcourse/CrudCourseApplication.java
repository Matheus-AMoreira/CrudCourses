package com.course.crudcourse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.course.crudcourse.model.Course;
import com.course.crudcourse.repository.CourseRepository;

@SpringBootApplication
public class CrudCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudCourseApplication.class, args);
	}

}
