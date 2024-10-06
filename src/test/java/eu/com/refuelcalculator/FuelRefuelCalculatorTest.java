package eu.com.refuelcalculator;

import static java.util.Collections.*;
import static java.time.LocalDate.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

class FuelRefuelCalculatorTest {

    public static final String ILLEGAL_ARGUMENT_MESSAGE = "Input arguments should not be null";
    
    private final FuelRefuelCalculator refuelCalculator = new FuelRefuelCalculator();

    @Test
    void givenNullList_whenCountRefueledLiters_thenException() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> refuelCalculator.countRefueledLiters(null, MIN, MAX));
        assertEquals(ILLEGAL_ARGUMENT_MESSAGE, exception.getMessage());
    }

    @Test
    void givenNullStartDate_whenCountRefueledLiters_thenException() {
        List<Map<String, Bill>> actual = new ArrayList<>();
        var exception = assertThrows(IllegalArgumentException.class,
                () -> refuelCalculator.countRefueledLiters(actual, null, MAX));
        assertEquals(ILLEGAL_ARGUMENT_MESSAGE, exception.getMessage());
    }

    @Test
    void givenNullEndDate_whenCountRefueledLiters_thenException() {
        List<Map<String, Bill>> actual = new ArrayList<>();
        var exception = assertThrows(IllegalArgumentException.class,
                () -> refuelCalculator.countRefueledLiters(actual, MIN, null));
        assertEquals(ILLEGAL_ARGUMENT_MESSAGE, exception.getMessage());
    }

    @Test
    void givenNullMap_whenCountRefueledLiters_thenEmptyMap() {
        List<Map<String, Bill>> actual = new ArrayList<>();
        actual.add(null);
        assertEquals(emptyMap(), refuelCalculator.countRefueledLiters(actual, MIN, MAX));
    }

    @Test
    void givenEmptyMap_whenCountRefueledLiters_thenEmptyMap() {
        List<Map<String, Bill>> actual = List.of(emptyMap());
        assertEquals(emptyMap(), refuelCalculator.countRefueledLiters(actual, MIN, MAX));
    }

    @Test
    void givenDateInterval_whenCountRefueledLiters_thenRefueledLitersByUsers() {
        var usersBillsMap1 = 
                Map.of("userId1", new Bill(20, of(2024, 2, 22)),
                       "userId2", new Bill(20, of(2024, 2, 22)),
                       "userId3", new Bill(20, of(2024, 2, 22)),
                       "userId4", new Bill(20, of(2024, 2, 22)));
        var usersBillsMap2 = 
                Map.of("userId1", new Bill(25, of(2024, 3, 21)),
                       "userId2", new Bill(25, of(2024, 3, 21)),
                       "userId3", new Bill(25, of(2024, 3, 21)),
                       "userId4", new Bill(25, of(2024, 3, 21)));
        var usersBillsMap3 = 
                Map.of("userId1", new Bill(18, of(2024, 4, 25)),
                       "userId2", new Bill(18, of(2024, 4, 25)),
                       "userId3", new Bill(18, of(2024, 4, 25)),
                       "userId4", new Bill(18, of(2024, 4, 25)));
        var usersBillsMap4 = 
                Map.of("userId1", new Bill(23, of(2024, 4, 28)),
                       "userId2", new Bill(23, of(2024, 4, 28)),
                       "userId3", new Bill(23, of(2024, 4, 28)),
                       "userId4", new Bill(23, of(2024, 4, 28)));
        var expected = 
                Map.of("userId1", 43,
                       "userId2", 43,
                       "userId3", 43,
                       "userId4", 43);
        assertEquals(expected,
                refuelCalculator.countRefueledLiters(
                        List.of(usersBillsMap1, usersBillsMap2, usersBillsMap3, usersBillsMap4), of(2024, 3, 1),
                        of(2024, 4, 25)));
    }

}