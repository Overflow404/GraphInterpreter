package validator;

import fetcher.FetchResult;
import operations.Operations;
import org.apache.commons.lang3.EnumUtils;
import tokenizer.Token;
import tokenizer.TokenizerResult;
import java.util.List;

public class GraphValidator implements Validator {

    /** @Precondition: Successful fetch. */
    @Override
    public ValidatorResult validate(TokenizerResult result) {
        if (isntWellKnownOperation(result)) {
            return ValidatorResult.createUnsuccessfulValidationResult();
        }

        if (malformedInstruction(result)) {
            return ValidatorResult.createUnsuccessfulValidationResult();
        }

        return null;
    }

    private boolean malformedInstruction(TokenizerResult result) {
        List<Token> tokens = result.getTokens();

        return true;
    }

    private boolean isntWellKnownOperation(TokenizerResult result) {
        Token operation = result.getOperation();
        return !EnumUtils.isValidEnum(Operations.class, operation.getToken().toUpperCase());
    }



}
