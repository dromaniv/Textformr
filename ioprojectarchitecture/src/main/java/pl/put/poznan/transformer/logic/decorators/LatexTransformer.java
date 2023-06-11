package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

/**
 * Class used to convert special characters to latex format.
 * It extends Decorator class.
 */
public class LatexTransformer extends Decorator {

    /**
     * Constructor of LatexTransformer class.
     * @param transformer AbstractTransformer object to be decorated.
     */
    public LatexTransformer(AbstractTransformer transformer) {
        super(transformer);
    }

    /**
     * Method used to convert special characters to latex format.
     * @param input String to be transformed.
     * @return String with converted special characters.
     */
    @Override
    public String transform(String input) {
        String convertedText = replaceSpecialCharacters(input);
        return super.transform(convertedText);
    }

    private String replaceSpecialCharacters(String input) {
        input = input.replace("\\", "\\textbackslash ");
        input = input.replace("//", "\\slash ");
        input = input.replace("<", "\\textless ");
        input = input.replace(">", "\\textgreater ");
        input = input.replace("|", "\\textbar ");
        input = input.replace("#", "\\# ");
        input = input.replace("%", "\\% ");
        input = input.replace("_", "\\_ ");
        input = input.replace("{", "\\{ ");
        input = input.replace("}", "\\} ");
        input = input.replace("~", "\\~ ");
        input = input.replace("^", "\\^ ");
        input = input.replace("&", "\\& ");
        input = input.replace("$", "\\$ ");

        return input;
    }
}
