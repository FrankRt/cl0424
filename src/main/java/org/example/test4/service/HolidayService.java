package org.example.test4.service;

import lombok.AllArgsConstructor;
import org.example.test4.entity.Holiday;
import org.example.test4.repository.HolidayRepository;
import org.example.test4.utilities.Utils;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

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
    public void populateHolidays(int year) {
        // First see if already populated. If so simply return.
        List<Holiday> holidays = holidayRepository.findByYrOrderByDate(year);
        if (holidays.size() > 0) {
            // Already populated, don't add more rows.
            return;
        }

        populateIndependenceDay(year);
        populateLaborDay(year);
    }

    /**
     * Persist July 4th, but if on weekend, then move to nearer of Friday, or Monday.
     *
     * @param year
     */
    private void populateIndependenceDay(int year) {
        holidayRepository.save(new Holiday(null, year, Utils.getIndepenceDayObserved(Year.of(year))));
    }

    /**
     * Persist date of 1st Monday in September.
     *
     * @param year
     */
    private void populateLaborDay(int year) {
        holidayRepository.save(new Holiday(null, year, Utils.getLaborDay(Year.of(year))));
    }

    /**
     * Query the Holiday table for the 2 holidays for the given year.
     *
     * @param year
     * @return - A list of the 2 holidays for the given year.
     */
    public List<Holiday> getHolidaysForYear(int year) {
        return holidayRepository.findByYrOrderByDate(year);
    }
}
