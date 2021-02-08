package me.aparna.printingquotes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintingQuotesTest {

    private PrintingQuotes printingQuotes;
    private Map<String, String> quotationsMap = Map.of("Aparna", "Howdy", "Arjuna", "Arrow");
    private List<String> keysList = quotationsMap.keySet().stream().collect(Collectors.toList());
    @BeforeEach
    public void init() {
        printingQuotes = new PrintingQuotes();
    }

    @Test
    public void testOnePlan() {
        printingQuotes.setInputs(quotationsMap.get(keysList.get(0)), keysList.get(0));
        assertEquals("Aparna says, \"Howdy\"", printingQuotes.getOutputString());
    }

    @Test
    public void testTwoPlan() {
        printingQuotes.setInputs(quotationsMap.get(keysList.get(1)), keysList.get(1));
        assertEquals("Arjuna says, \"Arrow\"", printingQuotes.getOutputString());
    }
}
