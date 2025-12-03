package tn.esprit.studentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class StudentManagementApplicationTests {

    @Test
    void contextLoads() {
      assertTrue(true);
    }
    @Test
    void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

}
