package tokenizer;

import fetcher.FetchResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SimpleTokenizerTest {

    private SpaceTokenizer tokenizer;

    @Before
    public void setup() {
        tokenizer = new SpaceTokenizer();
    }

    @Test
    public void successfulTokenizationTest() {
        FetchResult fetchingResult = FetchResult.createSuccessResult("test content");

        TokenizerResult tokenizationResult = tokenizer.tokenize(fetchingResult);
        List<String> tokens = tokenizationResult.getTokens();

        String token1 = "test";
        String token2 = "content";

        Assert.assertTrue(tokens.contains(token1));
        Assert.assertTrue(tokens.contains(token2));
    }

}
