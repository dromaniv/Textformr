package pl.put.poznan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.NumberConverter;

class NumberConverterTest {

    @Test
    void testTransform() { //TODO this test is not working properly guyssss
        AbstractTransformer mockTransformer = mock(AbstractTransformer.class);

        NumberConverter transformer = new NumberConverter(mockTransformer);

        String input = "I have 5 apples and 10 oranges.";
        String expectedOutput = "I have five apples and ten oranges.";

        when(mockTransformer.transform(input)).thenReturn(input);

        String actualOutput = transformer.transform(input);

        verify(mockTransformer).transform(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
