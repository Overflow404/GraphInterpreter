package tokenizer;

import interpreter.Result;
import java.util.List;

public class TokenizerResult {

    private List<String> tokens;
    private Result result;

    static  TokenizerResult createSuccessfulResult(List<String> tokens) {
        return new TokenizerResult().add(tokens).add(Result.SUCCESSFUL);
    }

    private TokenizerResult add(List<String> tokens) {
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

    public List<String> getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return "TokenizerResult{" +
                "tokens=" + tokens +
                ", result=" + result +
                '}';
    }
}
