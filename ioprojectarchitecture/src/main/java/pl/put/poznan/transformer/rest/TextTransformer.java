package pl.put.poznan.transformer.rest;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is responsible for instructing the transformers to transform the text
 * uses lower case but all the request preprocessing is done in the controller
 */
@Service
public class TextTransformer {

    public String transform(String input, List<String> transformations) {
        for (String transformation : transformations) {
            //TODO: This is a toy example, we will refactor it with the Decorator pattern
            switch (transformation) {
                case "uppercase":
                    input = input.toUpperCase();
                    break;
                case "lowercase":
                    input = input.toLowerCase();
                    break;
                case "capitalize":
                    input = input.substring(0, 1).toUpperCase() + input.substring(1);
                    break;
                case "invert":
                    input = new StringBuilder(input).reverse().toString();
                    break;
                default:
                    break;

            }
        }
        return input;
    }
}
