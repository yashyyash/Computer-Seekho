package com.seekho.api.service;

import com.seekho.api.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    CourseDTO getCoursebyId(int id);
    CourseDTO saveCourse(CourseDTO dto);
    void deleteCourse(int id);
}
