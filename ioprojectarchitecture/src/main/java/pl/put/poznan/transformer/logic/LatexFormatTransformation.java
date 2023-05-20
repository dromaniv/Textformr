package pl.put.poznan.transformer.logic;

public class LatexFormatTransformation extends TextTransformationDecorator {
    public LatexFormatTransformation(TextTransformation decoratedTextTransformation) {
        super(decoratedTextTransformation);
    }

    @Override
    public String transform(String text) {
        String result = super.transform(text);
        result = result.replace("&", "\\&");
        result = result.replace("$", "\\$");
        return result;
    }
}
