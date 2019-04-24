package tokenizer;

import results.Result;

import java.util.ArrayList;
import java.util.List;

public class TokenizerResult {

    private List<Token> tokens;
    private Result result;

    public static  TokenizerResult createSuccessfulTokenizationResult(List<Token> tokens) {
        return new TokenizerResult().addTokens(tokens).addResult(Result.SUCCESSFUL);
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

    public List<Token> getTokens() {
        return tokens;
    }

    public Token getOperation() {
        return tokens.get(0);
    }

    @Override
    public String toString() {
        return "TokenizerResult{" +
                "tokens=" + tokens +
                ", result=" + result +
                '}';
    }
}
