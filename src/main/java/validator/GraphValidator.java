package validator;

import fetcher.FetchResult;

import java.util.Arrays;
import java.util.List;

public class GraphValidator implements Validator {

    public enum Operation {
        ADD_NODE,
        ADD_EDGE
    }

    private int operationIndex;

    public GraphValidator() {
        operationIndex = 0;
    }

    /** @Precondition: Successful fetch. */
    @Override
    public ValidatorResult validate(FetchResult result) {
        List<String> tokens = tokenize(result.getContent());

        if (tokens.isEmpty()) {
            return ValidatorResult.createUnsuccessfulValidationResult();
        }

        String operation = tokens.get(operationIndex);
        //if (isWellKnownOperation(operation)) {

        //}
        return null;
    }

    //private boolean isWellKnownOperation(String operation) {

    //}

    private List<String> tokenize(String content) {
        return Arrays.asList(content.split("\\s+"));
    }

}
