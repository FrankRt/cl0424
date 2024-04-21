package org.example.test4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.test4.utilities.Utils;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalAgreement {
    private String    toolCode;
    private String    toolType;
    private String    toolBrand;
    private int       rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double    dailyRentalCharge;
    private int       numChargeDays;
    private double    prediscountCharge;
    private int       discountPct;
    private double    discountAmt;
    private double    finalCharge;

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Tool type: " + toolType + System.lineSeparator());
        sb.append("Tool code: " + toolCode + System.lineSeparator());
        sb.append("Tool brand: " + toolBrand + System.lineSeparator());
        sb.append("Rental days: " + rentalDays + System.lineSeparator());
        sb.append("Check out date: " + Utils.formatDate(checkoutDate) + System.lineSeparator());
        sb.append("Due date: " + Utils.formatDate(dueDate) + System.lineSeparator());
        sb.append("Daily rental charge: " + Utils.formatCurrency(dailyRentalCharge) + System.lineSeparator());
        sb.append("Charge days: " + numChargeDays + System.lineSeparator());
        sb.append("Pre-discount charge: " + Utils.formatCurrency(prediscountCharge) + System.lineSeparator());
        sb.append("Discount percent: " + Utils.formatPercent(discountPct) + System.lineSeparator());
        sb.append("Discount amount: " + Utils.formatCurrency(discountAmt) + System.lineSeparator());
        sb.append("Final charge: " + Utils.formatCurrency(finalCharge));

        return sb.toString();
    }
}
