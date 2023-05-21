package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

/**
 * Class used to transform text to lower case
 */
public class LowerCaseTransformer extends Decorator {

    /**
     * Constructor of LowerCaseTransformer class
     * @param transformer transformer to be decorated
     */
    public LowerCaseTransformer(AbstractTransformer transformer) {
        super(transformer);
    }

    /**
     * Method used to transform text to lower case
     * @param input input string
     * @return string in lower case
     */
    @Override
    public String transform(String input) {
        return transformer.transform(input).toLowerCase();
    }

}
