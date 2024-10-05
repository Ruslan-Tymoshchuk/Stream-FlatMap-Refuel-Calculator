package eu.com.refuelcalculator;

import static java.util.stream.Collectors.*;
import java.time.LocalDate;
import java.util.*;

public class FuelRefuelCalculator {
        
    public Map<String, Integer> countRefueledLiters(List<Map<String, Bill>> usersBills, 
                                                           LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null) {
            return usersBills 
                    .stream()
                    .filter(map -> map != null && !map.isEmpty())
                    .flatMap(map -> map.entrySet().stream())
                    .filter(entry -> entry.getValue().getDateRefueled().compareTo(startDate) >= 0
                            && entry.getValue().getDateRefueled().compareTo(endDate) <= 0)
                    .collect(toMap(Map.Entry::getKey, 
                                              entry -> entry.getValue().getLitersRefueled(),
                                              Integer::sum));
        } else {
            throw new IllegalArgumentException("Start date and end date cannot be null"); 
        }
    }
    
}