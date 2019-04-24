package tokenizer;

import results.FetchResult;
import results.TokenizerResult;

import java.util.ArrayList;
import java.util.List;

public class SimpleTokenizer implements Tokenizer {

    @Override
    public TokenizerResult tokenize(FetchResult result) {
        String content = result.getContent();
        List<Token> tokens = tokenizeInstruction(content);

        if (tokens.isEmpty()) {
            return TokenizerResult.createUnsuccessfulTokenizationResult();
        }
        return TokenizerResult.createSuccessfulTokenizationResult(tokens);
    }

    private List<Token> tokenizeInstruction(String instruction) {
        List<Token> tokens = new ArrayList<>();
        String[] stringTokens = instruction.split("\\s+");

        for (String stringToken: stringTokens) {
            Token token = new Token(stringToken);
            tokens.add(token);
        }

        return tokens;
    }

}
