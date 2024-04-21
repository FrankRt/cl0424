package org.example.test4.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test4.entity.Holiday;
import org.example.test4.entity.Tool;
import org.example.test4.entity.ToolType;
import org.example.test4.model.RentalAgreement;
import org.example.test4.repository.HolidayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
@Slf4j
public class RentalAgreementService {
    HolidayRepository holidayRepository;

    /**
     * Creates a RentalAgreement object via inputs. Note that inputs have been validated, so no need to do that here.
     *
     * @param tool - Tool that's getting rented
     * @param numRentalDays - Duration of rental in (24 hour) days
     * @param startDate - Date the rental begins and is charged for
     * @param discountPct - Percentage to reduce total charge
     * @return - A fully populated RentalAgreement instance
     */
    public RentalAgreement createRentalAgreement(Tool tool, int numRentalDays, LocalDate startDate, int discountPct) {
        final ToolType toolType = tool.getToolType();

        RentalAgreement ra = new RentalAgreement();

        ra.setToolCode(tool.getToolCode());
        ra.setToolType(toolType.getType());
        ra.setToolBrand(tool.getBrand());
        ra.setRentalDays(numRentalDays);
        ra.setCheckoutDate(startDate);
        ra.setDueDate(startDate.plusDays(numRentalDays));
        ra.setDailyRentalCharge(toolType.getDailyCharge());
        ra.setNumChargeDays(calculateChargeDays(startDate, numRentalDays));
        ra.setPrediscountCharge(ra.getNumChargeDays() * ra.getDailyRentalCharge());
        ra.setDiscountPct(discountPct);
        ra.setDiscountAmt(calculateDiscountAmt(ra.getPrediscountCharge(), ra.getDiscountPct()));
        ra.setFinalCharge(ra.getPrediscountCharge() - ra.getDiscountAmt());

        return ra;
    }

    /**
     * Calculates the number of days customer gets charged during the rental period. If a holiday fall within the
     * charge period, then the customer doesn't get charged that day.
     *
     * NOTE: If this is a 1 day charge period, and that day is a holiday, customer doesn't get charged. Something to
     * look into future cycles.
     *
     * @param startDate - Date when rental period starts (and potentially charged)
     * @param numRentalDays - Rental period length in days
     * @return - Rental period in days minus any holidays in that period
     */
    public int calculateChargeDays(final LocalDate startDate, int numRentalDays) {
        // Minus 1 because a one day rental would be a total of 1 day, thus
        // startDate equals endDate since endDate is inclusive for testing.
        final LocalDate endDateInclusive = startDate.plusDays(numRentalDays-1);
        final AtomicInteger totalRentalDays = new AtomicInteger(numRentalDays);
        final List<Holiday> holidays = holidayRepository.findByYrOrderByDate(startDate.getYear());

        holidays.stream().forEach(holiday -> {
            LocalDate h = holiday.getDate();
            if (h.isEqual(startDate) || h.isEqual(endDateInclusive)) {
                totalRentalDays.getAndDecrement();
            }
            else if (h.isAfter(startDate) && h.isBefore(endDateInclusive)) {
                totalRentalDays.getAndDecrement();
            }
        });

        return totalRentalDays.get();
    }

    /**
     * Calculates the discount via percentage discount.
     *
     * @param preDiscountCharge - Amount customer gets charged before discount
     * @param discountPct - Percentage reduction applied to charge amount
     * @return - Amount of discount
     */
    public double calculateDiscountAmt(double preDiscountCharge, int discountPct) {
        double discounted = preDiscountCharge * (discountPct / 100.0);
        return Math.round(discounted * 100.0) / 100.0;
    }
}
