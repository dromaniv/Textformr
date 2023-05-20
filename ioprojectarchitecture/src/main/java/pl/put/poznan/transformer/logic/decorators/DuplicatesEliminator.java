package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

public class DuplicatesEliminator extends Decorator {

    public DuplicatesEliminator(AbstractTransformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String input) {
        String output = transformer.transform(input);
        String[] words = output.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result += words[i];
            } else if (!words[i].equals(words[i - 1])) {
                result += " " + words[i];
            }
        }
        return result;
    }

}
