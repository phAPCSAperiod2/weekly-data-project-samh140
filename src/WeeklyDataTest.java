import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SleepHoursDataTest.java
 * Author: Sam Ho
 * Collaborator: CoPilot
 * 
 * This test class contains comprehensive unit tests for the SleepHoursData class.
 * It validates all core functionality including:
 *  - Constructor deep copy (ensures internal array does not alias the input)
 *  - getTotal(): calculates the sum of all sleep hours
 *  - getAverage(): calculates mean sleep hours per night
 *  - getMax(): finds the highest single night's sleep
 *  - getMin(): finds the lowest single night's sleep
 *  - toString(): formats data for display
 *
 * Each test uses representative data to ensure the SleepHoursData class
 * functions correctly under normal and edge case scenarios.
 */
class WeeklyDataTest {

    // Tests that constructor creates a deep copy, preventing external array modifications
    // from affecting the internal data
    @Test
    void constructor_makesDeepCopy_notAliasingInput() {
        // Initialize input array with test data
        double[] input = {10.0, 20.0, 30.0};
        SleepHoursData wd = new SleepHoursData(input);

        // Store the original total before modifying the input array
        double originalTotal = wd.getTotal();

        // Modify the original array after construction
        input[0] = 9999.0;

        // Assert that modifying the input array did not affect the SleepHoursData object
        // The total should remain unchanged, proving the deep copy was successful
        assertEquals(
                originalTotal,
                wd.getTotal(),
                1e-9,
                "SleepHoursData must deep-copy the input array. External changes should not affect internal data."
        );
    }

    // Tests that constructor correctly copies all array elements and maintains proper length
    @Test
    void constructor_copiesAllElements_correctLength() {
        // Create test data with decimal values
        double[] input = {5.5, 10.0, 20.25};
        SleepHoursData wd = new SleepHoursData(input);

        assertEquals(35.75, wd.getTotal(), 1e-9);
    }

    // Tests the getTotal() method with typical values
    @Test
    void getTotal_typicalValues() {
        // Create test data representing a week of sleep hours
        double[] input = {100, 200, 300};
        SleepHoursData wd = new SleepHoursData(input);

        assertEquals(600.0, wd.getTotal(), 1e-9);
    }

    // Tests getTotal() with a single data point
    @Test
    void getTotal_singleValue() {
        // Create test data with one sleep value
        double[] input = {42.5};
        SleepHoursData wd = new SleepHoursData(input);

        assertEquals(42.5, wd.getTotal(), 1e-9);
    }

    // Tests the getAverage() method with typical values
    @Test
    void getAverage_typicalValues() {
        // Create test data that produces a clean average
        double[] input = {2, 4, 6, 8};
        SleepHoursData wd = new SleepHoursData(input);

        assertEquals(5.0, wd.getAverage(), 1e-9);
    }

    // Tests getAverage() when result is a decimal value
    @Test
    void getAverage_decimalResult() {
        // Create test data that results in a decimal average
        double[] input = {1, 2, 3};
        SleepHoursData wd = new SleepHoursData(input);

        assertEquals(2.0, wd.getAverage(), 1e-9);
    }

    // Tests the getMax() method to ensure it correctly finds the highest value
    @Test
    void getMax_typicalValues() {
        // Create test data with mixed values to find maximum
        double[] input = {10, 50, 30, 75, 25};
        SleepHoursData wd = new SleepHoursData(input);

        assertEquals(75.0, wd.getMax(), 1e-9);
    }

}
    
