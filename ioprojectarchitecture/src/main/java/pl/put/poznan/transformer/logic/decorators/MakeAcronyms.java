package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

import java.util.HashMap;
import java.util.Map;

public class MakeAcronyms extends Decorator {
    private static final Map<String, String> ACRONYMS;

    static {
        ACRONYMS = new HashMap<>();
        ACRONYMS.put("for example", "e.g.");
        ACRONYMS.put("among others", "i.a.");
        ACRONYMS.put("and so on", "aso");
    }

    public MakeAcronyms(AbstractTransformer transformer) {
        super(transformer);
    }

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
