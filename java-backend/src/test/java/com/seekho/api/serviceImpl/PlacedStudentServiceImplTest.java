package com.seekho.api.serviceImpl;

import com.seekho.api.dto.PlacedStudentDTO;
import com.seekho.api.entity.BatchPlacementMaster;
import com.seekho.api.entity.PlacedStudent;
import com.seekho.api.mapper.PlacedStudentMapper;
import com.seekho.api.repository.BatchPlacementRepository;
import com.seekho.api.repository.PlacedStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlacedStudentServiceImplTest {

    @Mock
    private PlacedStudentRepository studentRepo;

    @Mock
    private BatchPlacementRepository batchRepo;

    @Mock
    private PlacedStudentMapper mapper;

    @InjectMocks
    private PlacedStudentServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddStudent() {
        // Arrange
        Long batchId = 1L;
        PlacedStudentDTO inputDto = new PlacedStudentDTO();
        inputDto.setBatchId(batchId);
        inputDto.setStudentName("John");
        inputDto.setCompanyName("Google");
        inputDto.setPhotoUrl("photo.jpg");
        inputDto.setActive(true);

        BatchPlacementMaster batch = new BatchPlacementMaster();
        PlacedStudent studentEntity = new PlacedStudent();
        PlacedStudent savedStudent = new PlacedStudent();
        PlacedStudentDTO expectedDto = new PlacedStudentDTO();
        expectedDto.setStudentName("John");

        when(batchRepo.findById(batchId.intValue())).thenReturn(Optional.of(batch));
        when(mapper.toEntity(inputDto, batch)).thenReturn(studentEntity);
        when(studentRepo.save(studentEntity)).thenReturn(savedStudent);
        when(mapper.toDTO(savedStudent)).thenReturn(expectedDto);

        // Act
        PlacedStudentDTO result = service.addStudent(inputDto);

        // Assert
        assertEquals(expectedDto.getStudentName(), result.getStudentName());
        verify(batchRepo).findById(batchId.intValue());
        verify(studentRepo).save(studentEntity);
        verify(mapper).toEntity(inputDto, batch);
        verify(mapper).toDTO(savedStudent);
    }

    @Test
    void testAddStudent_withWrongExpectation_shouldFail() {
        // Arrange
        Long batchId = 1L;
        PlacedStudentDTO inputDto = new PlacedStudentDTO();
        inputDto.setBatchId(batchId);
        inputDto.setStudentName("John");
        inputDto.setCompanyName("Google");
        inputDto.setPhotoUrl("photo.jpg");
        inputDto.setActive(true);

        BatchPlacementMaster batch = new BatchPlacementMaster();
        PlacedStudent studentEntity = new PlacedStudent();
        PlacedStudent savedStudent = new PlacedStudent();
        PlacedStudentDTO expectedDto = new PlacedStudentDTO();
        expectedDto.setStudentName("John");

        // Mocking properly
        when(batchRepo.findById(batchId.intValue())).thenReturn(Optional.of(batch));
        when(mapper.toEntity(inputDto, batch)).thenReturn(studentEntity);
        when(studentRepo.save(studentEntity)).thenReturn(savedStudent);
        when(mapper.toDTO(savedStudent)).thenReturn(expectedDto);

        // Act
        PlacedStudentDTO result = service.addStudent(inputDto);

        // Assert (INTENTIONAL FAILURE: expected "Jane", actual is "John")
        assertEquals("Jane", result.getStudentName(), "Student name mismatch (intentional fail)");
    }

    @Test
    void testAddStudent_missingBatch_shouldFailBecauseNoExceptionExpected() {
        // Arrange
        Long batchId = 1L;
        PlacedStudentDTO inputDto = new PlacedStudentDTO();
        inputDto.setBatchId(batchId);

        // Batch not found
        when(batchRepo.findById(batchId.intValue())).thenReturn(Optional.empty());

        // Act
        // (INTENTIONAL MISTAKE: No exception handling/assertion, so it will fail with uncaught RuntimeException)
        service.addStudent(inputDto);
    }

}
