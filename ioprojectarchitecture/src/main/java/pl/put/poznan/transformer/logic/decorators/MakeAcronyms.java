package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * Class used to make acronyms in the text.
 * It extends Decorator class.
 */
public class MakeAcronyms extends Decorator {
    private static final Map<String, String> ACRONYMS;

    static {
        ACRONYMS = new HashMap<>();
        ACRONYMS.put("for example", "e.g.");
        ACRONYMS.put("among others", "i.a.");
        ACRONYMS.put("and so on", "aso");
    }

    /**
     * Constructor of MakeAcronyms class.
     * @param transformer AbstractTransformer object to be decorated.
     */
    public MakeAcronyms(AbstractTransformer transformer) {
        super(transformer);
    }

    /**
     * Method used to make acronyms in the text.
     * @param input String to be transformed.
     * @return String with made acronyms.
     */
    @Override
    public String transform(String input) {
        String output = super.transform(input);

        for (Map.Entry<String, String> entry : ACRONYMS.entrySet()) {
            String phrase = entry.getKey();
            String acronym = entry.getValue();

            output = output.replaceAll("(?i)\\b" + phrase + "\\b", acronym);
        }

        return output;
    }
}
