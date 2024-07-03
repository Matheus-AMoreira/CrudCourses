package com.course.crudcourse.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CourseDTO(
        Long _id,
        @NotBlank @NotNull @Length(min = 5, max = 100) String name,
        @NotNull @Length(min = 5, max = 10) @Pattern(regexp = "Back-end | Front-end") String category,
        @NotNull @NotEmpty @Valid List<LessonDTO> lessons) {
}
