package pl.put.poznan.test;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.CapitalizeTransformer;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeTransformerTest {
    CapitalizeTransformer capitalizeTransformer;
    AbstractTransformer abstractTransformer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        abstractTransformer = new AbstractTransformer() {
            @Override
            public String transform(String input) {
                return input;
            }
        };
        capitalizeTransformer = new CapitalizeTransformer(abstractTransformer);
    }

    @org.junit.jupiter.api.Test
    void transform() {
        assertEquals("Test", capitalizeTransformer.transform("test"));
        assertEquals("Test", capitalizeTransformer.transform("TEST"));
        assertEquals("Test", capitalizeTransformer.transform("tEsT"));
        assertEquals("Test", capitalizeTransformer.transform("Test"));
        assertEquals("Test", capitalizeTransformer.transform("tEST"));
        assertEquals(" ", capitalizeTransformer.transform(" "));
        assertEquals("A B C D E", capitalizeTransformer.transform("a b c d e"));
        assertEquals("@hello World!", capitalizeTransformer.transform("@hello world!"));
        //assertEquals("", capitalizeTransformer.transform("")); //TODO: fix this test
    }
}