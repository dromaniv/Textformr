package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

/**
 * Class used to transform text to upper case
 */
public class UpperCaseTransformer extends Decorator{

    /**
     * Constructor of UpperCaseTransformer class
     * @param transformer transformer to be decorated
     */
    public UpperCaseTransformer(AbstractTransformer transformer) {
        super(transformer);
    }

    /**
     * Method used to transform text to upper case
     * @param input input string
     * @return string in upper case
     */
    @Override
    public String transform(String input) {
        return transformer.transform(input).toUpperCase();
    }

}
