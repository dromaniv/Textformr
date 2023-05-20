package pl.put.poznan.transformer.rest;

import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.logic.decorators.CapitalizeTransformer;
import pl.put.poznan.transformer.logic.decorators.Inverter;
import pl.put.poznan.transformer.logic.decorators.LowerCaseTransformer;
import pl.put.poznan.transformer.logic.decorators.UpperCaseTransformer;

import java.util.List;

/**
 * This class is responsible for instructing the transformers to transform the text
 * uses lower case but all the request preprocessing is done in the controller
 */
@Service
public class TextTransformer {


    /**
     * This method transforms the input text using the transformations
     * @param input the text to be transformed
     * @param transformations the list of transformations to be applied
     * @return the transformed text
     */

    public String transform(String input, List<String> transformations) {
        for (String transformation : transformations) {
            //TODO: This is a toy example, we will refactor it with the Decorator pattern
            switch (transformation) {
                case "uppercase":
                    input = new UpperCaseTransformer(input1 -> input1).transform(input);
                    break;
                case "lowercase":
                    input = new LowerCaseTransformer(input1 -> input1).transform(input);
                    break;
                case "capitalize":
                    input = new CapitalizeTransformer(input1 -> input1).transform(input);
                    break;
                case "invert":
                    input = new Inverter(input1 -> input1).transform(input);
                    break;
                default:
                    break;

            }

        }
        return input;
    }
}
