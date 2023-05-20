package pl.put.poznan.transformer.logic;

public class CapitalizeTransformation extends TextTransformationDecorator {
    public CapitalizeTransformation(TextTransformation decoratedTextTransformation) {
        super(decoratedTextTransformation);
    }
    @Override
    public String transform(String text) {
        String[] words = text.split(" ");
        String result = "";
        for (String word : words) {
            result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return result;
    }
}
