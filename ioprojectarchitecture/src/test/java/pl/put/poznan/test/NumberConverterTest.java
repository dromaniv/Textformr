package pl.put.poznan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.NumberConverter;

class NumberConverterTest {

    @Test
    void testTransformWithSingleNumber() {
        AbstractTransformer mockTransformer = new AbstractTransformer() {
            @Override
            public String transform(String input) {
                return input;  // Return the input without any transformation
            }
        };

        NumberConverter transformer = new NumberConverter(mockTransformer);

        String input = "I have 5 apples.";
        String expectedOutput = " I have five apples.";

        String actualOutput = transformer.transform(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testTransformWithMultipleNumbers() {
        AbstractTransformer mockTransformer = new AbstractTransformer() {
            @Override
            public String transform(String input) {
                return input;  // Return the input without any transformation
            }
        };

        NumberConverter transformer = new NumberConverter(mockTransformer);

        String input = "There are 12 days in a year and 60 minutes in an hour.";
        String expectedOutput = " There are twelve days in a year and sixty minutes in an hour.";

        String actualOutput = transformer.transform(input);

        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    void testTransformWithNegativeNumber() {
        AbstractTransformer mockTransformer = new AbstractTransformer() {
            @Override
            public String transform(String input) {
                return input;  // Return the input without any transformation
            }
        };

        NumberConverter transformer = new NumberConverter(mockTransformer);

        String input = "The temperature is -10 degrees Celsius.";
        String expectedOutput = " The temperature is minus ten degrees Celsius.";

        String actualOutput = transformer.transform(input);

        assertEquals(expectedOutput, actualOutput);
    }

}
