package pl.put.poznan.transformer.logic;

public class EliminateRepetitionTransformation extends TextTransformationDecorator {
    public EliminateRepetitionTransformation(TextTransformation decoratedTextTransformation) {
        super(decoratedTextTransformation);
    }

    @Override
    public String transform(String text) {
        String[] words = super.transform(text).split("\\s");
        StringBuilder result = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i - 1])) {
                result.append(" ").append(words[i]);
            }
        }
        return result.toString();
    }
}