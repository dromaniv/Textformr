package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Decorator;
import pl.put.poznan.transformer.logic.AbstractTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List pos = WhereUpperCase(input);
        String lower_input = input.toLowerCase();
        //reverse the string
        String reverse = new StringBuffer(lower_input).reverse().toString();
        //change the case of the letters
        char[] ch = reverse.toCharArray();
        for (int i = 0; i < pos.size(); i++) {
            ch[(int) pos.get(i)] = Character.toUpperCase(ch[(int) pos.get(i)]);
        }
        return new String(ch);
    }

    private List WhereUpperCase(String input) {
        List<Integer> pos = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                pos.add(i);
            }
        }
        return pos;
    }
}