package eu.com.refuelcalculator;

import static java.time.LocalDate.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class FuelRefuelCalculatorTest {

    private final FuelRefuelCalculator refuelCalculator = new FuelRefuelCalculator();

    @Test
    void givenNullList_whenCountRefueledLiters_thenException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> refuelCalculator.countRefueledLiters(null, MIN, MAX));
        assertEquals("Input arguments should not be null", exception.getMessage());
    }

    @Test
    void givenNullStartDate_whenCountRefueledLiters_thenException() {
        List<Map<String, Bill>> actual = new ArrayList<>();
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> refuelCalculator.countRefueledLiters(actual, null, MAX));
        assertEquals("Input arguments should not be null", exception.getMessage());
    }

    @Test
    void givenNullEndDate_whenCountRefueledLiters_thenException() {
        List<Map<String, Bill>> actual = new ArrayList<>();
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> refuelCalculator.countRefueledLiters(actual, MIN, null));
        assertEquals("Input arguments should not be null", exception.getMessage());
    }

    @Test
    void givenDateInterval_whenCountRefueledLiters_thenRefueledLitersByUsers() {
        Map<String, Bill> usersBillsMap1 = new HashMap<>();
        usersBillsMap1.put("userId1", new Bill(20, of(2024, 2, 22)));
        usersBillsMap1.put("userId2", new Bill(20, of(2024, 2, 22)));
        usersBillsMap1.put("userId3", new Bill(20, of(2024, 2, 22)));
        usersBillsMap1.put("userId4", new Bill(20, of(2024, 2, 22)));
        Map<String, Bill> usersBillsMap2 = new HashMap<>();
        usersBillsMap2.put("userId1", new Bill(25, of(2024, 3, 21)));
        usersBillsMap2.put("userId2", new Bill(25, of(2024, 3, 21)));
        usersBillsMap2.put("userId3", new Bill(25, of(2024, 3, 21)));
        usersBillsMap2.put("userId4", new Bill(25, of(2024, 3, 21)));
        Map<String, Bill> usersBillsMap3 = new HashMap<>();
        usersBillsMap3.put("userId1", new Bill(18, of(2024, 4, 25)));
        usersBillsMap3.put("userId2", new Bill(18, of(2024, 4, 25)));
        usersBillsMap3.put("userId3", new Bill(18, of(2024, 4, 25)));
        usersBillsMap3.put("userId4", new Bill(18, of(2024, 4, 25)));
        Map<String, Bill> usersBillsMap4 = new HashMap<>();
        usersBillsMap4.put("userId1", new Bill(23, of(2024, 4, 28)));
        usersBillsMap4.put("userId2", new Bill(23, of(2024, 4, 28)));
        usersBillsMap4.put("userId3", new Bill(23, of(2024, 4, 28)));
        usersBillsMap4.put("userId4", new Bill(23, of(2024, 4, 28)));
        List<Map<String, Bill>> actual = List.of(usersBillsMap1, usersBillsMap2, usersBillsMap3, usersBillsMap4);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("userId1", 43);
        expected.put("userId2", 43);
        expected.put("userId3", 43);
        expected.put("userId4", 43);
        assertEquals(expected, refuelCalculator.countRefueledLiters(actual, of(2024, 3, 1), of(2024, 4, 25)));
    }

}