package junit_test;

import com.tma.pxbao.java_core.immutable.Student;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestImmutable {
    Student s;

    @BeforeAll
    void initStudent() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        s = new Student("miChaEl OWen", 101, map);
        System.out.println("\nBefore all test case");
    }

    @BeforeEach
    void setUp() {
        System.out.println("\nBefore test case");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After test case");
    }


    @Test
    @DisplayName("Test case can not change attribute hashmap of student")
    @Order(2)
    void testChangeStudentMetadata() {
        s.getMetadata().put("3", "third");
        assertNull(s.getMetadata().get("3"));
        System.out.println("testChangeStudentMetadata is passed");
    }

    @Test
    @DisplayName("Test case name of student is formatted before get")
    @Order(1)
    void testNameFormatted() {
        assertEquals("Michael Owen", s.getName());
        System.out.println("testNameFormatted is passed");
    }



    @AfterAll
    void clearData() {
        s = null;
        System.out.println("\nAfter all test case");
    }

}
