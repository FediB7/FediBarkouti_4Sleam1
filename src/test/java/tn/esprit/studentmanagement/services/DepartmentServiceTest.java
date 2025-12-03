package tn.esprit.studentmanagement.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void testGetDepartmentById() {
        Department dep = new Department();
        dep.setIdDepartment(1L);
        dep.setName("IT");

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(dep));

        Department result = departmentService.getDepartmentById(1L);

        assertNotNull(result);
        assertEquals("IT", result.getName());
    }

    @Test
    void testAddDepartment() {
        Department dep = new Department();
        dep.setName("Finance");

        when(departmentRepository.save(dep)).thenReturn(dep);

        Department result = departmentService.addDepartment(dep);

        assertEquals("Finance", result.getName());
        verify(departmentRepository, times(1)).save(dep);
    }
}
