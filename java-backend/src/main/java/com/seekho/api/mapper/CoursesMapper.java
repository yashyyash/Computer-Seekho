package com.seekho.api.mapper;

import com.seekho.api.dto.CourseDTO;
import com.seekho.api.entity.Courses;

public class CoursesMapper {

    public CourseDTO toDTO(Courses entity) {
        CourseDTO dto = new CourseDTO();
        dto.setCourse_id(entity.getCourse_id());
        dto.setCourse_name(entity.getCourse_name());
        dto.setCourse_code(entity.getCourse_code());
        dto.setDescription(entity.getDescription());
        dto.setDuration(entity.getDuration());
        dto.setTotal_fee(entity.getTotal_fee());
        dto.setIs_active(entity.isIs_active());

        // Map new fields
        dto.setSyllabus(entity.getSyllabus());
        dto.setAge_group(entity.getAge_group());
        dto.setCover_photo_url(entity.getCover_photo_url());

        return dto;
    }

    public Courses toEntity(CourseDTO dto) {
        Courses entity = new Courses();
        entity.setCourse_id(dto.getCourse_id());
        entity.setCourse_name(dto.getCourse_name());
        entity.setCourse_code(dto.getCourse_code());
        entity.setDescription(dto.getDescription());
        entity.setDuration(dto.getDuration());
        entity.setTotal_fee(dto.getTotal_fee());
        entity.setIs_active(dto.isIs_active());

        // Map new fields
        entity.setSyllabus(dto.getSyllabus());
        entity.setAge_group(dto.getAge_group());
        entity.setCover_photo_url(dto.getCover_photo_url());

        return entity;
    }
}
