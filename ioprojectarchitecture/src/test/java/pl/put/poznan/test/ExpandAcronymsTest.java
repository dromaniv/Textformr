package pl.put.poznan.test;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.ExpandAcronyms;

import static org.junit.jupiter.api.Assertions.*;

class ExpandAcronymsTest {

    ExpandAcronyms expandAcronyms;

    AbstractTransformer abstractTransformer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        abstractTransformer = new AbstractTransformer() {
            @Override
            public String transform(String input) {
                return input;
            }
        };
        expandAcronyms = new ExpandAcronyms(abstractTransformer);
    }

    @org.junit.jupiter.api.Test
    void transform() {
        assertEquals("professor", expandAcronyms.transform("prof."));
        assertEquals("doctor", expandAcronyms.transform("dr"));
        assertEquals("dr.", expandAcronyms.transform("dr."));
        assertEquals("professor", expandAcronyms.transform("professor"));
        assertEquals("prof", expandAcronyms.transform("prof"));
    }
}