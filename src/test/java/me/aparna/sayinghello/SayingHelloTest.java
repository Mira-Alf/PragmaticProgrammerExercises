package me.aparna.sayinghello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class SayingHelloTest {

    private SayingHello sayingHello;
    private List<String> names = List.of("Aparna", "Arjuna", "Bheema");


    @BeforeEach
    public void init() {
        this.sayingHello = new SayingHello();
    }

    @Test
    public void testOnePlan() {
        sayingHello.setName(names.get(0));
        assertEquals( "Hello, Aparna, nice to meet you!", sayingHello.getGreeting() );
    }

    @Test
    public void testTwoPlan() {
        sayingHello.setName(names.get(1));
        assertEquals( "Hello, Arjuna, nice to meet you!", sayingHello.getGreeting() );
    }

    @Test
    public void testThreePlan() {
        sayingHello.setName(names.get(2));
        assertEquals( "Hello, Bheema, nice to meet you!", sayingHello.getGreeting() );
    }
}
