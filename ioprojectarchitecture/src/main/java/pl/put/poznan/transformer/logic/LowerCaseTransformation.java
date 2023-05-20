package pl.put.poznan.transformer.logic;

public class LowerCaseTransformation extends TextTransformationDecorator {
    public LowerCaseTransformation(TextTransformation decoratedTextTransformation) {
        super(decoratedTextTransformation);
    }

    @Override
    public String transform(String text) {
        return super.transform(text).toLowerCase();
    }
}

