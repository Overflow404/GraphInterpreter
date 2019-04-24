package validator;

import results.Result;

public class ValidatorResult {

    private static final String EMPTY_STRING = "";
    private Result result;
    private String content;

    private ValidatorResult() {}

    public static ValidatorResult createSuccessfulValidationResult(String content) {
        return new ValidatorResult().addContent(content).addResult(Result.SUCCESSFUL);
    }

    public static ValidatorResult createUnsuccessfulValidationResult() {
        return new ValidatorResult().addContent(EMPTY_STRING).addResult(Result.UNSUCCESSFUL);
    }

    private ValidatorResult addResult(Result result) {
        this.result = result;
        return this;
    }

    private ValidatorResult addContent(String content) {
        this.content = content;
        return this;
    }

}
