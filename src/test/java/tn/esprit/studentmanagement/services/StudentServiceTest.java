package tn.esprit.studentmanagement.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.repositories.StudentRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGetStudentById() {
        Student s = new Student();
        s.setIdStudent(5L);
        s.setName("Ali");

        when(studentRepository.findById(5L)).thenReturn(Optional.of(s));

        Student result = studentService.getStudentById(5L);

        assertNotNull(result);
        assertEquals("Ali", result.getName());
    }

    @Test
    void testAddStudent() {
        Student s = new Student();
        s.setName("Yassine");

        when(studentRepository.save(s)).thenReturn(s);

        Student result = studentService.addStudent(s);

        assertEquals("Yassine", result.getName());
        verify(studentRepository, times(1)).save(s);
    }
}
