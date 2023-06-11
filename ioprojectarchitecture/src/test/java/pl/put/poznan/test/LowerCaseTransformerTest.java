package pl.put.poznan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.LowerCaseTransformer;

class LowerCaseTransformerTest {

    @Test
    void testTransform() {
        AbstractTransformer mockTransformer = mock(AbstractTransformer.class);

        LowerCaseTransformer transformer = new LowerCaseTransformer(mockTransformer);

        String input = "Hello World";
        String expectedOutput = "hello world";

        when(mockTransformer.transform(input)).thenReturn("HELLO WORLD");

        String actualOutput = transformer.transform(input);

        verify(mockTransformer).transform(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
