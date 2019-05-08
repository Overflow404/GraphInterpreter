package tokenizer;

import fetcher.FetchResult;

import java.util.Arrays;
import java.util.List;

public class SpaceTokenizer implements Tokenizer {
    @Override
    public TokenizerResult tokenize(FetchResult result) {
        String command = result.getCommand();
        List<String> tokens = Arrays.asList(command.split("\\s+"));
        return TokenizerResult.createSuccessfulResult(tokens);
    }
}
