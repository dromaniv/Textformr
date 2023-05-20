package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

public class EliminateRepetitionTransformation extends Decorator {

    public EliminateRepetitionTransformation(AbstractTransformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String input) {
        String output = transformer.transform(input);
        String[] words = output.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result.append(words[i]);
            } else if (!words[i].equals(words[i - 1])) {
                result.append(" ").append(words[i]);
            }
        }
        return result.toString();
    }
}