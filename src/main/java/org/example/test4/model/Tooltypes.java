package org.example.test4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TOOL_TYPES")
public class Tooltypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String type;
    private Double dailyCharge;
    private Boolean weekdayCharge;
    private Boolean weekendCharge;
    private Boolean holidayCharge;
}


//CREATE TABLE TOOL_TYPES (
//        id INT AUTO_INCREMENT PRIMARY KEY,
//        type VARCHAR(30) NOT NULL,
//daily_charge DOUBLE NOT NULL,
//weekday_charge BOOLEAN NOT NULL,
//weekend_charge BOOLEAN NOT NULL,
//holiday_charge BOOLEAN NOT NULL
//);
