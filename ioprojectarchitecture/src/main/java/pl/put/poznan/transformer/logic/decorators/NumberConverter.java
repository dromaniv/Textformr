package pl.put.poznan.transformer.logic.decorators;

import java.util.HashMap;
import java.util.Map;

public class NumberConverter {
    private static final Map<Integer, String> NUMBERS = new HashMap<>();

    static {
        NUMBERS.put(0, "zero");
        NUMBERS.put(1, "one");
        NUMBERS.put(2, "two");
        NUMBERS.put(3, "three");
        NUMBERS.put(4, "four");
        NUMBERS.put(5, "five");
        NUMBERS.put(6, "six");
        NUMBERS.put(7, "seven");
        NUMBERS.put(8, "eight");
        NUMBERS.put(9, "nine");
        NUMBERS.put(10, "ten");
        NUMBERS.put(11, "eleven");
        NUMBERS.put(12, "twelve");
        NUMBERS.put(13, "thirteen");
        NUMBERS.put(14, "fourteen");
        NUMBERS.put(15, "fifteen");
        NUMBERS.put(16, "sixteen");
        NUMBERS.put(17, "seventeen");
        NUMBERS.put(18, "eighteen");
        NUMBERS.put(19, "nineteen");
        NUMBERS.put(20, "twenty");
        NUMBERS.put(30, "thirty");
        NUMBERS.put(40, "forty");
        NUMBERS.put(50, "fifty");
        NUMBERS.put(60, "sixty");
        NUMBERS.put(70, "seventy");
        NUMBERS.put(80, "eighty");
        NUMBERS.put(90, "ninety");
    }

    public static String convertNumberToText(int number) {
        if (number < 0) {
            return "minus " + convertNumberToText(-number);
        }

        if (number < 100) {
            return convertLessThan100(number);
        }

        if (number < 1000) {
            return convertLessThan1000(number);
        }

        return convertGreaterThanOrEqualTo1000(number);
    }

    private static String convertLessThan100(int number) {
        if (NUMBERS.containsKey(number)) {
            return NUMBERS.get(number);
        }

        int tens = (number / 10) * 10;
        int ones = number % 10;

        return NUMBERS.get(tens) + "-" + NUMBERS.get(ones);
    }

    private static String convertLessThan1000(int number) {
        int hundreds = number / 100;
        int remainder = number % 100;

        String text = NUMBERS.get(hundreds) + " hundred";
        if (remainder != 0) {
            text += " " + convertLessThan100(remainder);
        }

        return text;
    }

    private static String convertGreaterThanOrEqualTo1000(int number) {
        int thousands = number / 1000;
        int remainder = number % 1000;

        String text = convertLessThan1000(thousands) + " thousand";
        if (remainder != 0) {
            text += " " + convertLessThan1000(remainder);
        }

        return text;
    }
}