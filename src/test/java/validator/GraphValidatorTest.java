package validator;

import fetcher.ConsoleFetcher;
import fetcher.FetchResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tokenizer.Token;
import tokenizer.TokenizerResult;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GraphValidatorTest {

    private GraphValidator validator;

    @Before
    public void setup() {
        validator = new GraphValidator();
    }

    @Test
    public void successfulValidationTest() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("add_edGE"));

        TokenizerResult tokenizationResult = TokenizerResult.createSuccessfulTokenizationResult(tokens);

        ValidatorResult validationResult = validator.validate(tokenizationResult);
        Assert.assertTrue(validationResult.isSuccessful());
    }

    @Test
    public void unsuccessfulValidationTest() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("add_1node"));

        TokenizerResult tokenizationResult = TokenizerResult.createSuccessfulTokenizationResult(tokens);

        ValidatorResult validationResult = validator.validate(tokenizationResult);
        Assert.assertFalse(validationResult.isSuccessful());
    }
}
