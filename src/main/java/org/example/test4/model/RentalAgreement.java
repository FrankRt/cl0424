package org.example.test4.model;

import jakarta.persistence.criteria.From;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalAgreement {
    private String toolCode;
    private String toolType;
    private String toolBrand;
    private int    rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double    dailyRentalCharge;
    private double    prediscountCharge;
    private int       discountPct;
    private double    discountAmt;
    private double    finalCharge;

}



//● Tool code - Specified at checkout
//● Tool type - From tool info
//● Tool brand - From tool info
//● Rental days - Specified at checkout
//● Check out date - Specified at checkout
//● Due date - Calculated from checkout date and rental days.
//● Daily rental charge - Amount per day, specified by the tool type.
//● Charge days - Count of chargeable days, from day after checkout through and including due
//date, excluding “no charge” days as specified by the tool type.
//● Pre-discount charge - Calculated as charge days X daily charge. Resulting total rounded half up
//to cents.
//        ● Discount percent - Specified at checkout.
//● Discount amount - calculated from discount % and pre-discount charge. Resulting amount
//rounded half up to cents.
//● Final charge - Calculated as pre-discount charge - discount amount.
