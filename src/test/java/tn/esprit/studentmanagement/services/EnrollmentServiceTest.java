package tn.esprit.studentmanagement.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.repositories.EnrollmentRepository;

@ExtendWith(MockitoExtension.class)
class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @Test
    void testGetEnrollmentById() {
        Enrollment e = new Enrollment();
        e.setIdEnrollment(10L);

        when(enrollmentRepository.findById(10L)).thenReturn(Optional.of(e));

        Enrollment result = enrollmentService.getEnrollmentById(10L);

        assertNotNull(result);
        assertEquals(10L, result.getIdEnrollment());
    }

    @Test
    void testAddEnrollment() {
        Enrollment e = new Enrollment();
        e.setIdEnrollment(20L);

        when(enrollmentRepository.save(e)).thenReturn(e);

        Enrollment result = enrollmentService.addEnrollment(e);

        assertEquals(20L, result.getIdEnrollment());
        verify(enrollmentRepository, times(1)).save(e);
    }
}
