package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDto {

    String courseName;

}
