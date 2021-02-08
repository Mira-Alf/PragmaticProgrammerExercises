package me.aparna.tipcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTipCalculatorTest {

    private BasicTipCalculator calculator;
    private List<Double> amounts = List.of(200.0, 10.0, 11.25);
    private List<Integer> tipAmounts = List.of(15, 15, 15);
    @BeforeEach
    public void init() {
        calculator = new BasicTipCalculator();
    }

    @Test
    public void testOnePlan() {
        calculator.setInputs(amounts.get(0), tipAmounts.get(0));
        calculator.calculateTotal();
        assertAll(
                ()->assertEquals("$30.00", calculator.getTip()),
                ()->assertEquals("$230.00", calculator.getTotal())
        );
    }

    @Test
    public void testTwoPlan() {
        calculator.setInputs(amounts.get(1), tipAmounts.get(1));
        calculator.calculateTotal();
        assertAll(
                ()->assertEquals("$1.50", calculator.getTip()),
                ()->assertEquals("$11.50", calculator.getTotal())
        );
    }

    @Test
    public void testThreePlan() {
        calculator.setInputs(amounts.get(2), tipAmounts.get(2));
        calculator.calculateTotal();
        assertAll(
                ()->assertEquals("$1.69", calculator.getTip()),
                ()->assertEquals("$12.94", calculator.getTotal())
        );
    }
}
