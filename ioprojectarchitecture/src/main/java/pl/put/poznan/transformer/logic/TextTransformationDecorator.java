package pl.put.poznan.transformer.logic;

public abstract class TextTransformationDecorator implements TextTransformation {
    protected TextTransformation decoratedTextTransformation;

    public TextTransformationDecorator(TextTransformation decoratedTextTransformation) {
        this.decoratedTextTransformation = decoratedTextTransformation;
    }

    public String transform(String text) {
        return decoratedTextTransformation.transform(text);
    }
}