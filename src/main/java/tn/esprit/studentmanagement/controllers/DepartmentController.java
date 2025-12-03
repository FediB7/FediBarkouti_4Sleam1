package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    public DepartmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDepartments() {
        when(departmentRepository.findAll())
                .thenReturn(Arrays.asList(new Department(), new Department()));

        List<Department> departments = departmentService.getAllDepartments();

        assertEquals(2, departments.size());
    }

    @Test
    void testGetDepartmentById() {
        Department dep = new Department();
        dep.setId(1L);

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(dep));

        Department result = departmentService.getDepartmentById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testSaveDepartment() {
        Department dep = new Department();
        dep.setName("INFO");

        when(departmentRepository.save(dep)).thenReturn(dep);

        Department result = departmentService.saveDepartment(dep);

        assertEquals("INFO", result.getName());
    }

    @Test
    void testDeleteDepartment() {
        departmentService.deleteDepartment(1L);
        verify(departmentRepository, times(1)).deleteById(1L);
    }
}
