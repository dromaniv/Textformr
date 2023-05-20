package pl.put.poznan.transformer.logic;

public class UpperCaseTransformation extends TextTransformationDecorator {
    public UpperCaseTransformation(TextTransformation decoratedTextTransformation) {
        super(decoratedTextTransformation);
    }

    @Override
    public String transform(String text) {
        return super.transform(text).toUpperCase();
    }
}

