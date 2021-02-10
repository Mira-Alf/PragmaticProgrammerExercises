package me.aparna.retirementcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RetirementCalculatorTest {

    private RetirementCalculator calculator;

    @BeforeEach
    public void init() {
        calculator = new RetirementCalculator();
    }

    @Test
    public void testOnePlan() {
        calculator.setAges(25, 65);
        calculator.processRetirement();
        assertAll(
                ()->assertEquals(40, calculator.getYearsLeft()),
                ()->assertEquals(Year.now().plusYears(40).getValue(), 2061)
        );
    }
}
