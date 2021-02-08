package me.aparna.simplemath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleMathCalculatorTest {
    private SimpleMathCalculator calculator;
    private List<Integer> firstInputs = List.of(10, 20);
    private List<Integer> secondInputs = List.of(5, 10);
    @BeforeEach
    public void init() {
        this.calculator = new SimpleMathCalculator();
    }

    @Test
    public void testOnePlan() {
        calculator.setInputs(firstInputs.get(0), secondInputs.get(0));
        calculator.performOperations();
        assertAll(
                ()->assertEquals(15, calculator.getSum()),
                ()->assertEquals(5, calculator.getDiff()),
                ()->assertEquals(50, calculator.getProd()),
                ()->assertEquals(2, calculator.getQuot())
        );
    }

    @Test
    public void testTwoPlan() {
        calculator.setInputs(firstInputs.get(1), secondInputs.get(1));
        calculator.performOperations();
        assertAll(
                ()->assertEquals(30, calculator.getSum()),
                ()->assertEquals(10, calculator.getDiff()),
                ()->assertEquals(200, calculator.getProd()),
                ()->assertEquals(2, calculator.getQuot())
        );
    }
}
