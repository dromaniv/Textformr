package pl.put.poznan.transformer.rest;

import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * This class is responsible for instructing the transformers to transform the text
 * uses lower case but all the request preprocessing is done in the controller
 */
public class TransformTextRequest {
    private String text;

    private List<String> transformations;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public List<String> getTransformations() {
        return transformations;
    }

    public void setTransformations(List<String> transformations) {
        this.transformations = transformations;
    }
}
