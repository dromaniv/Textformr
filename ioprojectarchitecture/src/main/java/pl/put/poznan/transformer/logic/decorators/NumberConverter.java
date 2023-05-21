package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.Decorator;

/**
 * Class used to transform numbers to text
 */
public class NumberConverter extends Decorator {

    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    /**
     * Constructor of NumberConverter class
     * @param transformer transformer to be decorated
     */
    public NumberConverter(AbstractTransformer transformer) {
        super(transformer);
    }

    /**
     * Method used to transform numbers to text
     * @param input input string
     * @return string with numbers transformed to text
     */
    @Override
    public String transform(String input) {
        String[] words = input.split(" ");
        String output = "";
        for (int i = 0; i < words.length; i++) {
            output+=" ";
            try {
                int number = Integer.parseInt(words[i]);
                output+=(convertNumberToText(number));
            } catch (NumberFormatException e) {
                output+=words[i];
            }
        }
        return output;
    }

    private String convertNumberToText(int number) {
        if (number < 0) {
            return "minus " + convertNumberToText(-number);
        }
        if (number == 0) {
            return "zero";
        }
        if (number < 100) {
            return convertLessThan100(number);
        }
        if (number < 1000) {
            return convertLessThan1000(number);
        }
        return convertEqualTo1000(number);
    }

    private String convertLessThan100(int number) {
        if (number < 20) {
            return units[number];
        }
        int unit = number % 10;
        int ten = number / 10;
        return tens[ten] + (unit != 0 ? " " + units[unit] : "");
    }

    private String convertLessThan1000(int number) {
        int hundred = number / 100;
        int rest = number % 100;
        return units[hundred] + " hundred" + (rest != 0 ? " and " + convertLessThan100(rest) : "");
    }

    private String convertEqualTo1000(int number) {
        if (number == 1000)
            return "one thousand";
        System.out.println("ERROR: Convertion of numbers greater than 1000 is not supported");
        return "ERROR:NUMBER_TOO_BIG";
    }
}