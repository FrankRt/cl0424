package org.example.test4.service;

import lombok.AllArgsConstructor;
import org.example.test4.entity.Holiday;
import org.example.test4.repository.HolidayRepository;
import org.example.test4.utilities.Utils;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
@AllArgsConstructor
public class HolidayService {
    private HolidayRepository holidayRepository;

    /**
     * Populating ONLY Independence and Labor days in the HOLIDAYS
     * table for the current year.
     *
     * @Todo Make this more general where we'd input a list of holidays for a year, then populate all. In fact we may
     * need multiple years (but no more than two) in the HOLIDAYS table for when rentals would extend over and including
     * New Year's Day. Example: a 10 day rental including Christmas Day and New Year's Day and where those rental days
     * would be charge free.
     */
    public void populateHolidays() {
        populateIndependenceDay();
        populateLaborDay();
    }

    private void populateIndependenceDay() {
        holidayRepository.save(new Holiday(1, Utils.getIndepenceDayObserved(Year.now())));
    }

    private void populateLaborDay() {
        holidayRepository.save(new Holiday(2, Utils.getLaborDay(Year.now())));
    }
}
