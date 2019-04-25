package tokenizer;

import results.Result;
import java.util.List;

public class TokenizerResult {

    private List<Token> tokens;
    private Result result;

    public static  TokenizerResult createSuccessfulResult(List<Token> tokens) {
        return new TokenizerResult().add(tokens).add(Result.SUCCESSFUL);
    }

    private TokenizerResult add(List<Token> tokens) {
        this.tokens = tokens;
        return this;
    }

    private TokenizerResult add(Result result) {
        this.result = result;
        return this;
    }

    public boolean isSuccessful() {
        return result == Result.SUCCESSFUL;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public String getOperation() {
        if (tokens == null || tokens.size() < 1)
            throw new IllegalStateException("No operation found.");
        return tokens.get(0).getTokenString().toUpperCase();
    }

    @Override
    public String toString() {
        return "TokenizerResult{" +
                "tokens=" + tokens +
                ", result=" + result +
                '}';
    }
}
