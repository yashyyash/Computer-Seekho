package com.seekho.api.controller;

import com.seekho.api.dto.CourseDTO;
import com.seekho.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable int id) {
        return courseService.getCoursebyId(id);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO dto) {
        return courseService.saveCourse(dto);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable int id, @RequestBody CourseDTO dto) {
        dto.setCourse_id(id); // ensure ID is set
        return courseService.saveCourse(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
