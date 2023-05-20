package pl.put.poznan.transformer.logic;

public class ReverseTransformation extends TextTransformationDecorator {
    public ReverseTransformation(TextTransformation decoratedTextTransformation) {
        super(decoratedTextTransformation);
    }

    @Override
    public String transform(String text) {
        String reversed = new StringBuilder(super.transform(text)).reverse().toString();
        // Preserve case
        StringBuilder result = new StringBuilder(reversed.length());
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            char original = text.charAt(text.length() - i - 1);
            if (Character.isUpperCase(original)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }
}
