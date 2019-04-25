package syntaxvalidator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tokenizer.Token;
import tokenizer.TokenizerResult;

import java.util.ArrayList;
import java.util.List;

public class GraphValidatorTest {

    private GraphValidator validator;

    @Before
    public void setup() {
        validator = new GraphValidator();
    }

    @Test
    public void successfulNodeValidationTest() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("adD_nOdE"));
        tokens.add(new Token("A"));

        TokenizerResult tokenizationResult = TokenizerResult.createSuccessfulResult(tokens);

        ValidatorResult validationResult = validator.validate(tokenizationResult);
        Assert.assertTrue(validationResult.isSuccessful());
    }

    @Test
    public void unsuccessfulNodeValidationTest() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("adD_nOdE"));

        TokenizerResult tokenizationResult = TokenizerResult.createSuccessfulResult(tokens);

        ValidatorResult validationResult = validator.validate(tokenizationResult);
        Assert.assertFalse(validationResult.isSuccessful());
    }

    @Test
    public void successfulEdgeValidationTest() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("adD_eDGE"));
        tokens.add(new Token("A"));
        tokens.add(new Token("B"));


        TokenizerResult tokenizationResult = TokenizerResult.createSuccessfulResult(tokens);

        ValidatorResult validationResult = validator.validate(tokenizationResult);
        Assert.assertTrue(validationResult.isSuccessful());
    }

    @Test
    public void unsuccessfulEdgeValidationTest() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("adD_eDGE"));
        tokens.add(new Token("A"));

        TokenizerResult tokenizationResult = TokenizerResult.createSuccessfulResult(tokens);

        ValidatorResult validationResult = validator.validate(tokenizationResult);
        Assert.assertFalse(validationResult.isSuccessful());
    }
}
