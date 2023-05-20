package pl.put.poznan.transformer.rest;

import org.springframework.beans.factory.annotation.Required;

import java.util.List;

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
