package pl.put.poznan.transformer.logic;

public class AcronymExpansionTransformation extends TextTransformationDecorator {
    public AcronymExpansionTransformation(TextTransformation decoratedTextTransformation) {
        super(decoratedTextTransformation);
    }

    @Override
    public String transform(String text) {
        String result = super.transform(text);
        result = result.replace("e.g.", "for example");
        result = result.replace("i.a.", "among others");
        result = result.replace("aso", "and so on");
        return result;
    }
}