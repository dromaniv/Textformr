package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

public class LowerCaseTransformer extends Decorator {

    public LowerCaseTransformer(AbstractTransformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String input) {
        return transformer.transform(input).toLowerCase();
    }

}
