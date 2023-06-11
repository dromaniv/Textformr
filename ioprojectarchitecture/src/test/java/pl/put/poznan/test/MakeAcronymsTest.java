package pl.put.poznan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.MakeAcronyms;

class MakeAcronymsTest {

    @Test
    void testTransform() {
        AbstractTransformer mockTransformer = mock(AbstractTransformer.class);

        MakeAcronyms transformer = new MakeAcronyms(mockTransformer);

        String input = "This is an example sentence, among others.";
        String expectedOutput = "This is an example sentence, i.a..";

        when(mockTransformer.transform(input)).thenReturn(input);

        String actualOutput = transformer.transform(input);

        verify(mockTransformer).transform(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
