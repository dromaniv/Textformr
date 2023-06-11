package pl.put.poznan.test;

import pl.put.poznan.transformer.logic.AbstractTransformer;
import pl.put.poznan.transformer.logic.decorators.LatexTransformer;

import static org.junit.jupiter.api.Assertions.*;

class LatexTransformerTest {

    LatexTransformer latexTransformer;

    AbstractTransformer abstractTransformer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        abstractTransformer = new AbstractTransformer() {
            @Override
            public String transform(String input) {
                return input;
            }
        };
        latexTransformer = new LatexTransformer(abstractTransformer);
    }

    @org.junit.jupiter.api.Test
    void transform() {
        assertEquals("\\textbackslash ", latexTransformer.transform("\\"));
        assertEquals("\\slash ", latexTransformer.transform("//"));
        assertEquals("\\~ ", latexTransformer.transform("~"));
        assertEquals("\\$ ", latexTransformer.transform("$"));
        assertEquals("\\textbackslash \\slash ", latexTransformer.transform("\\//"));
        assertEquals("\\textless \\textgreater \\textbar \\# \\% \\_ \\{ \\} \\~ \\^ \\& \\$ ", latexTransformer.transform("<>|#%_{}~^&$"));
        assertEquals("Test \\textbackslash \\slash ", latexTransformer.transform("Test \\//"));
        assertEquals("Test \\textless \\textgreater \\textbar \\# \\% \\_ \\{ \\} \\~ \\^ \\& \\$ ", latexTransformer.transform("Test <>|#%_{}~^&$"));
        assertEquals("Test \\textbackslash \\slash  Test \\textless \\textgreater \\textbar \\# \\% \\_ \\{ \\} \\~ \\^ \\& \\$ ", latexTransformer.transform("Test \\// Test <>|#%_{}~^&$"));
    }

}