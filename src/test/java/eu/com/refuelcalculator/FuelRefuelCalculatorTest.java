package eu.com.refuelcalculator;

import static java.time.LocalDate.*;
import static org.junit.jupiter.api.Assertions.*;
import  java.util.*;

import org.junit.jupiter.api.Test;

class FuelRefuelCalculatorTest {

    private final FuelRefuelCalculator refuelCalculator = new FuelRefuelCalculator();

    @Test
     void givenNullList_whenCountRefueledLiters_thenException(){
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> refuelCalculator.countRefueledLiters(null, MIN, MAX));
        assertEquals("Input arguments should not be null", exception.getMessage());
    }

    @Test
    void givenNullStartDate_whenCountRefueledLiters_thenException(){
       List<Map<String, Bill>> actual = new ArrayList<>(); 
       Throwable exception = assertThrows(IllegalArgumentException.class,
               () -> refuelCalculator.countRefueledLiters(actual, null, MAX));
       assertEquals("Input arguments should not be null", exception.getMessage());
   }
    
    @Test
    void givenNullEndDate_whenCountRefueledLiters_thenException(){
       List<Map<String, Bill>> actual = new ArrayList<>(); 
       Throwable exception = assertThrows(IllegalArgumentException.class,
               () -> refuelCalculator.countRefueledLiters(actual, MIN, null));
       assertEquals("Input arguments should not be null", exception.getMessage());
   }
    
}