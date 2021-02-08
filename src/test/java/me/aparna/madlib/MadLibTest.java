package me.aparna.madlib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MadLibTest {

    private MadLib madLib;
    @BeforeEach
    public void init() {
        madLib = new MadLib();
    }

    @Test
    public void testOnePlan() {
        madLib.setInputs("dog", "walk", "blue", "quickly");
        assertEquals("Do you walk your blue dog quickly? That's hilarious!", madLib.getOutputString());
    }
}
