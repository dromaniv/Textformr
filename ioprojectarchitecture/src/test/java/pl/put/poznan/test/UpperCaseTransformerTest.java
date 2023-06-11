package pl.put.poznan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.UpperCaseTransformer;

class UpperCaseTransformerTest {

    @Test
    void testTransform() {
        AbstractTransformer mockTransformer = mock(AbstractTransformer.class);

        UpperCaseTransformer transformer = new UpperCaseTransformer(mockTransformer);

        String input = "Hello, World!";
        String transformedInput = "HELLO, WORLD!";
        String expectedOutput = transformedInput.toUpperCase();

        when(mockTransformer.transform(input)).thenReturn(transformedInput);

        String actualOutput = transformer.transform(input);

        verify(mockTransformer).transform(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
