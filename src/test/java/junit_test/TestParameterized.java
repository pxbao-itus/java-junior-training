package junit_test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestParameterized {

    // This test will run 3 times with different arguments
    @Test
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test_int_arrays(int arg) {
        assertTrue(arg > 0);
    }

    @Test
    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(ints = {1, 2, 3})
    void test_int_arrays_custom_name(int arg) {
        assertTrue(arg > 0);
    }

    @Test
    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(strings = {"apple", "banana", "orange"})
    void test_string_arrays_custom_name(String arg) {
        assertTrue(arg.length() > 1);
    }

}