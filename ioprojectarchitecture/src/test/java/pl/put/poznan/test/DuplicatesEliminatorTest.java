package pl.put.poznan.test;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.DuplicatesEliminator;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatesEliminatorTest {

    DuplicatesEliminator duplicatesEliminator;

    AbstractTransformer abstractTransformer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        abstractTransformer = new AbstractTransformer() {
            @Override
            public String transform(String input) {
                return input;
            }
        };
        duplicatesEliminator = new DuplicatesEliminator(abstractTransformer);
    }

    @org.junit.jupiter.api.Test
    void transform() {
        assertEquals("Test", duplicatesEliminator.transform("Test"));
        assertEquals("Test", duplicatesEliminator.transform("Test Test"));
        assertEquals("Test", duplicatesEliminator.transform("Test Test Test"));
        assertEquals("two to two", duplicatesEliminator.transform("two to two"));
        assertEquals("two to two", duplicatesEliminator.transform("two to to two"));
        assertEquals("two to", duplicatesEliminator.transform("two to to"));
    }
}