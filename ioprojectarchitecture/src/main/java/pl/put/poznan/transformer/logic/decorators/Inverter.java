package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Decorator;
import pl.put.poznan.transformer.logic.AbstractTransformer;
import org.springframework.stereotype.Service;

/**
 * Class used to invert the input text
 */
@Service
public class Inverter extends Decorator {

    public Inverter(AbstractTransformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String input) {
        //inverter should preserve the position of upper and lower case letters
        //split the input into letters
        String[] letters = input.split("");
        //create a list of positions of upper case letters
        int[] upperCasePositions = new int[letters.length];
        int upperCaseCount = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals(letters[i].toUpperCase())) {
                upperCasePositions[upperCaseCount] = i;
                upperCaseCount++;
            }
        }
        //lower case all letters
        for (int i = 0; i < letters.length; i++) {
            letters[i] = letters[i].toLowerCase();
        }
        //reverse the order of letters
        for (int i = 0; i < letters.length / 2; i++) {
            String temp = letters[i];
            letters[i] = letters[letters.length - i - 1];
            letters[letters.length - i - 1] = temp;
        }
        //upper case letters in their original positions
        for (int i = 0; i < upperCaseCount; i++) {
            letters[upperCasePositions[i]] = letters[upperCasePositions[i]].toUpperCase();
        }
        return input;
    }
}