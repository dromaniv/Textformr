// TextTransformerController.java
package pl.put.poznan.transformer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class is responsible for handling requests
 */
@RestController
@RequestMapping("/transform")
public class TextTransformerController {

    private TextTransformer textTransformer;

    /**
     * This method sets the text transformer
     * @param textTransformer the text transformer to be set
     */
    @Autowired
    public void setTextTransformer(TextTransformer textTransformer) {
        this.textTransformer = textTransformer;
    }

    /**
     * This method transforms the input text using the transformations
     * @param request the request containing the text and the transformations
     * @return the transformed text
     */
    @PostMapping
    public String transform(@RequestBody TransformTextRequest request) {
        if (request.getText() == null || request.getTransformations() == null) {
            return "Invalid request";
        }
        return this.textTransformer.transform(request.getText(), request.getTransformations());
    }
}
