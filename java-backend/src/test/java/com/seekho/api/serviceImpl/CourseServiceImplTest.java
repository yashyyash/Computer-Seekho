package com.seekho.api.serviceImpl;

import com.seekho.api.dto.CourseDTO;
import com.seekho.api.entity.Courses;
import com.seekho.api.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCourseById() {
        Courses course = new Courses();
        course.setCourse_id(1);
        course.setCourse_name("Java");
        course.setCourse_code("J101");
        course.setDescription("Learn Java");
        course.setDuration("2 months");
        course.setTotal_fee(5000);
        course.setIs_active(true);

        when(courseRepository.findById(1)).thenReturn(Optional.of(course));

        CourseDTO result = courseService.getCoursebyId(1);
        assertNotNull(result);
        assertEquals("Java", result.getCourse_name());
    }

    @Test
    void testGetCourseById_NotFound() {
        when(courseRepository.findById(99)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            courseService.getCoursebyId(99);
        });

        assertTrue(exception.getMessage().contains("Course not found"));
    }
}
