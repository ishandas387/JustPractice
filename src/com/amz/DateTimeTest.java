package com.amz;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateTimeTest {
    public static void main(String[] args) {
        LocalDate d = LocalDate.of(2015, 8, 12);
        DayOfWeek dw = d.getDayOfWeek();

        System.out.println();
    }
    
}
