package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

/**
 * Class used to capitalize first letter of each word
 */
public class CapitalizeTransformer extends Decorator{

    /**
     * Constructor of CapitalizeTransformer class
     * @param transformer transformer to be decorated
     */
    public CapitalizeTransformer(AbstractTransformer transformer) {
        super(transformer);
    }

    /**
     * Method used to capitalize first letter of each word
     * @param input input string
     * @return string with capitalized first letter of each word
     */
    @Override
    public String transform(String input) {
        String[] words = input.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }
}
