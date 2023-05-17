// TextTransformerController.java
package pl.put.poznan.transformer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transform")
public class TextTransformerController {

    private TextTransformer textTransformer;

    @Autowired
    public void setTextTransformer(TextTransformer textTransformer) {
        this.textTransformer = textTransformer;
    }

    @PostMapping
    public String transform(@RequestBody TransformTextRequest request) {
        return this.textTransformer.transform(request.getText(), request.getTransformations());
        //TODO verify transformations

    }
}
