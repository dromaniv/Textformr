package pl.put.poznan.test;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.Inverter;

import static org.junit.jupiter.api.Assertions.*;

class InverterTest {

    Inverter inverter;

    AbstractTransformer abstractTransformer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        abstractTransformer = new AbstractTransformer() {
            @Override
            public String transform(String input) {
                return input;
            }
        };
        inverter = new Inverter(abstractTransformer);
    }

    @org.junit.jupiter.api.Test
    void transform() {
        assertEquals("Olleh", inverter.transform("Hello"));
        assertEquals("", inverter.transform(""));
        assertEquals("9876543210", inverter.transform("0123456789"));
    }

}