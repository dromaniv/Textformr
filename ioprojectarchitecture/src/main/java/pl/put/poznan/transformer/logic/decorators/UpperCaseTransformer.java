package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

public class UpperCaseTransformer extends Decorator{

    public UpperCaseTransformer(AbstractTransformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String input) {
        return transformer.transform(input).toUpperCase();
    }

}
