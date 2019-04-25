package tokenizer;

import fetcher.FetchResult;

import java.util.ArrayList;
import java.util.List;

public class SimpleTokenizer implements Tokenizer {

    @Override
    public TokenizerResult tokenize(FetchResult result) {
        String command = result.getCommand();
        List<Token> tokens = tokenizeCommand(command);
        return TokenizerResult.createSuccessfulResult(tokens);
    }

    private List<Token> tokenizeCommand(String instruction) {
        List<Token> tokens = new ArrayList<>();
        String[] stringTokens = instruction.split("\\s+");

        for (String stringToken: stringTokens) {
            Token token = new Token(stringToken);
            tokens.add(token);
        }

        return tokens;
    }

}
