package me.aparna.countingcharacters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingCharactersTest {

    private CountingCharacters countingCharacters;
    private static List<String> inputs = List.of("Homer", "Aparna", "Arjuna");
    @BeforeEach
    public void init() {
        countingCharacters = new CountingCharacters();
    }

    @Test
    public void testOnePlan() {
        countingCharacters.setInputString(inputs.get(0));
        assertEquals("Homer has 5 characters.", countingCharacters.getOutputString());
    }

    @Test
    public void testTwoPlan() {
        countingCharacters.setInputString(inputs.get(1));
        assertEquals("Aparna has 6 characters.", countingCharacters.getOutputString());
    }

    @Test
    public void testThreePlan() {
        countingCharacters.setInputString(inputs.get(2));
        assertEquals("Arjuna has 6 characters.", countingCharacters.getOutputString());
    }

}
