package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Decorator;
import pl.put.poznan.transformer.logic.AbstractTransformer;
import org.springframework.stereotype.Service;

/**
 * Class used to invert the input text
 */
@Service
public class Inverter extends Decorator {

    public Inverter(AbstractTransformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String input) {
        String transformedInput = transformer.transform(input);
        StringBuilder result = new StringBuilder(transformedInput).reverse();
        return result.toString();
    }
}