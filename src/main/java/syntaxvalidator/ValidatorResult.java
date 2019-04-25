package syntaxvalidator;

import results.Result;
import tokenizer.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidatorResult {

    private static final List<Token> EMPTY_LIST = new ArrayList<>();
    private Result result;
    private List<Token> tokens;

    private ValidatorResult() {}

    public static ValidatorResult createSuccessfulResult(List<Token> tokens) {
        return new ValidatorResult().addTokens(tokens).addResult(Result.SUCCESSFUL);
    }

    public static ValidatorResult createUnsuccessfulResult() {
        return new ValidatorResult().addTokens(EMPTY_LIST).addResult(Result.UNSUCCESSFUL);
    }

    private ValidatorResult addResult(Result result) {
        this.result = result;
        return this;
    }

    private ValidatorResult addTokens(List<Token> tokens) {
        this.tokens = tokens;
        return this;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public boolean isSuccessful() {
        return result == Result.SUCCESSFUL;
    }

    public String getOperation() {
        if (tokens == null || tokens.size() < 1)
            throw new IllegalStateException("No operation found.");
        return tokens.get(0).getTokenString().toUpperCase();
    }

    @Override
    public String toString() {
        return "ValidatorResult{" +
                "result=" + result +
                ", tokens=" + tokens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidatorResult that = (ValidatorResult) o;
        return result == that.result &&
                Objects.equals(tokens, that.tokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, tokens);
    }
}
