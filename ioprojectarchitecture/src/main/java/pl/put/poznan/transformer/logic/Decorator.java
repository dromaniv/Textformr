package pl.put.poznan.transformer.logic;

/**
 * Class not used directly, but used to create decorators
 */
public abstract class Decorator implements AbstractTransformer {
    protected AbstractTransformer transformer;

    public Decorator(AbstractTransformer transformer) {
        this.transformer = transformer;
    }

    public String transform(String input) {
        return transformer.transform(input);
    }

}