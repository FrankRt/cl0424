package org.example.test4.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test4.exception.DiscountPercentOutOfRangeException;
import org.example.test4.exception.NoSuchToolCodeException;
import org.example.test4.entity.Tool;
import org.example.test4.exception.RentalPeriodOutOfRangeException;
import org.example.test4.exception.RentalStartDateException;
import org.example.test4.model.RentalAgreement;
import org.example.test4.repository.ToolRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CheckoutService {
    private ToolRepository         toolRepository;
    private RentalAgreementService rentalAgreementService;

    /**
     * Tries to check out a tool rental based on input parameters. Inputs are of course checked for
     * failures.
     *
     * @param toolCode - String used to lookup tool in Tool table.
     * @param rentalDayCount - Number of days rental is requested.
     * @throws NoSuchToolCodeException - When we can't find the tool in table via toolCode
     * @throws RentalPeriodOutOfRangeException - When too short or too long of a requested rental period
     */
    public RentalAgreement checkOut(String toolCode, int rentalDayCount, int discountPct, LocalDate startDate)
      throws NoSuchToolCodeException, RentalPeriodOutOfRangeException, DiscountPercentOutOfRangeException,
        RentalStartDateException
    {
        Tool tool = checkTool(toolCode);
        checkRentalPeriod(rentalDayCount);
        checkDiscountPct(discountPct);
        checkStartDate(startDate);

        return rentalAgreementService.createRentalAgreement(tool);
    }

    private void checkStartDate(LocalDate startDate) throws RentalStartDateException {
        if (startDate == null) {
            throw new RentalStartDateException("Must supply a rental start date");
        }
        if (startDate.isBefore(LocalDate.now())) {
            throw new RentalStartDateException("Rental start date can't begin before today");
        }
    }

    private void checkDiscountPct(int discountPct) throws DiscountPercentOutOfRangeException {
        if (discountPct < 0 || discountPct > 100) {
            throw new DiscountPercentOutOfRangeException("Discount percent of " +
                discountPct + " must be between 0 and 100");

        }
    }

    /**
     * Check for rental request period.
     * @param rentalDayCount - Number of tool rental days requested
     * @throws RentalPeriodOutOfRangeException - Thrown when too few or too great of period requested
     */
    private void checkRentalPeriod(int rentalDayCount) throws RentalPeriodOutOfRangeException {
        if (rentalDayCount < 1) {
            throw new RentalPeriodOutOfRangeException("Rental period must be at least 1 day");
        }

        // Hard coded for now, in future sprints will need put in a properties file, or added to
        // Tools table where each tool can have a distinct maximum rental days.
        if (rentalDayCount > 30) {
            throw new RentalPeriodOutOfRangeException("Rental period cannot exceed 30 days");
        }
    }

    /**
     * Get the tool, and if not found throw an exception
     * @param toolCode - String used to look up tool in Tool table
     * @return found tool
     * @throws NoSuchToolCodeException - If no tool found with the toolCode
     */
    private Tool checkTool(String toolCode) throws NoSuchToolCodeException {
        List<Tool> tool = toolRepository.findByToolCode(toolCode);

        if (tool == null || tool.size() == 0) {
            throw new NoSuchToolCodeException("No tool found with code " + toolCode);
        }

        // NOTE: tool.toolCode is marked as unique. IF this changes in the future, then this
        // needs to be revisited, and compared against loaned out tools table (future work).
        // For now, we just have 1 tool of each code.
        return tool.get(0);
    }
}
