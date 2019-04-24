package results;

import tokenizer.Token;

import java.util.ArrayList;
import java.util.List;

public class TokenizerResult {

    private static final List<Token> EMPTY_LIST = new ArrayList<>();

    private List<Token> tokens;
    private Result result;

    public static  TokenizerResult createSuccessfulTokenizationResult(List<Token> tokens) {
        return new TokenizerResult().addTokens(tokens).addResult(Result.SUCCESSFUL);
    }

    public static TokenizerResult createUnsuccessfulTokenizationResult() {
        return new TokenizerResult().addTokens(EMPTY_LIST).addResult(Result.UNSUCCESSFUL);
    }

    private TokenizerResult addTokens(List<Token> tokens) {
        this.tokens = tokens;
        return this;
    }

    private TokenizerResult addResult(Result result) {
        this.result = result;
        return this;
    }

    public boolean isSuccessful() {
        return result == Result.SUCCESSFUL;
    }

    @Override
    public String toString() {
        return "TokenizerResult{" +
                "tokens=" + tokens +
                ", result=" + result +
                '}';
    }
}
