package tokenizer;

import fetcher.FetchResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SimpleTokenizerTest {

    private SimpleTokenizer tokenizer;

    @Before
    public void setup() {
        tokenizer = new SimpleTokenizer();
    }

    @Test
    public void successfulTokenizationTest() {
        FetchResult fetchingResult = FetchResult.createSuccessFetchResult("test content");

        TokenizerResult tokenizationResult = tokenizer.tokenize(fetchingResult);
        List<Token> tokens = tokenizationResult.getTokens();

        Token token1 = new Token("test");
        Token token2 = new Token("content");

        Assert.assertTrue(tokens.contains(token1));
        Assert.assertTrue(tokens.contains(token2));
    }

}
