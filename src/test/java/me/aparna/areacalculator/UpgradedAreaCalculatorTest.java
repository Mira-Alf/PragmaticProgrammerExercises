package me.aparna.areacalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpgradedAreaCalculatorTest {

    private UpgradedAreaCalculator calculator;

    @BeforeEach
    public void init() {
        this.calculator = new UpgradedAreaCalculator();
    }

    @Test
    public void testOnePlan() {
        calculator.setDimensions(Unit.METRE, 15, 20);
        assertAll(
                ()->assertEquals(300.000, calculator.getAreaInSquareMetres()),
                ()->assertEquals(3229.161, calculator.getAreaInSquareFeet())
        );
    }
}
