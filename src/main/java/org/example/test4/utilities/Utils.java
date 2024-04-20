package org.example.test4.utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Date;

public final class Utils {

    public static LocalDate getIndepenceDayObserved(Year year) {
        LocalDate jul4 = LocalDate.parse(year + "-07-04");

        DayOfWeek dow = jul4.getDayOfWeek();
        if (dow == DayOfWeek.SATURDAY) {
            return LocalDate.parse(year + "-07-03");
        }
        else if (dow == DayOfWeek.SUNDAY) {
            return LocalDate.parse(year + "-07-05");
        }
        else {
            return jul4;
        }
    }

    public static LocalDate getLaborDay(Year year) {
        Month sep = Month.SEPTEMBER;

        final String yearMon = year + "-09-";
        for (int day = 1; day <= 7; day++) {
            LocalDate toTest = LocalDate.parse(yearMon + "0" + day);
            if (toTest.getDayOfWeek() == DayOfWeek.MONDAY) {
                return toTest;
            }
        }

        // Will never get here unless number of days per week is changed from 7 :)
        return null;
    }
}
