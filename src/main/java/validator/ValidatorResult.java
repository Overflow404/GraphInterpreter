package validator;

import results.Result;
import tokenizer.Token;

import java.util.ArrayList;
import java.util.List;

public class ValidatorResult {

    private static final List<Token> EMPTY_LIST = new ArrayList<>();
    private Result result;
    private List<Token> tokens;

    private ValidatorResult() {}

    public static ValidatorResult createSuccessfulValidationResult(List<Token> tokens) {
        return new ValidatorResult().addTokens(tokens).addResult(Result.SUCCESSFUL);
    }

    public static ValidatorResult createUnsuccessfulValidationResult() {
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

    public boolean isSuccessful() {
        return result == Result.SUCCESSFUL;
    }

    @Override
    public String toString() {
        return "ValidatorResult{" +
                "result=" + result +
                ", tokens=" + tokens +
                '}';
    }
}
