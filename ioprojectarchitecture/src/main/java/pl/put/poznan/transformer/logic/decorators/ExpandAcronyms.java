package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

import java.util.HashMap;
import java.util.Map;

public class ExpandAcronyms extends Decorator {
    private static final Map<String, String> EXPANSIONS;

    static {
        EXPANSIONS = new HashMap<>();
        EXPANSIONS.put("prof.", "professor");
        EXPANSIONS.put("dr", "doctor");
        EXPANSIONS.put("e.g.", "for example");
        EXPANSIONS.put("aso", "and so on");
    }

    public ExpandAcronyms(AbstractTransformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String input) {
        String[] words = super.transform(input).split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (EXPANSIONS.containsKey(word.toLowerCase())) {
                word = EXPANSIONS.get(word.toLowerCase());
                if (Character.isUpperCase(words[i].charAt(0))) {
                    word = word.substring(0, 1).toUpperCase() + word.substring(1);
                }
            }
            result += word + " ";
        }

        return result;
    }
}
