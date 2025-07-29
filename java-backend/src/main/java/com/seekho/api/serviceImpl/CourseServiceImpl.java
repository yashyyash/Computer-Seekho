package com.seekho.api.serviceImpl;

import com.seekho.api.dto.CourseDTO;
import com.seekho.api.entity.Courses;
import com.seekho.api.mapper.CoursesMapper;
import com.seekho.api.repository.CourseRepository;
import com.seekho.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private final CoursesMapper mapper = new CoursesMapper();

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Courses> courseList = courseRepository.findAll();
        return courseList.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCoursebyId(int id) {
        Courses course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
        return mapper.toDTO(course);
    }

    @Override
    public CourseDTO saveCourse(CourseDTO dto) {
        Courses course = mapper.toEntity(dto);
        Courses saved = courseRepository.save(course);
        return mapper.toDTO(saved);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
