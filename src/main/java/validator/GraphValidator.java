package validator;

import operations.Operations;
import org.apache.commons.lang3.EnumUtils;
import tokenizer.Token;
import tokenizer.TokenizerResult;

import java.util.List;


public class GraphValidator implements Validator {

    @Override
    public ValidatorResult validate(TokenizerResult result) {

        if (!isAWellKnownOperation(result)) {
            return ValidatorResult.createUnsuccessfulResult();
        }

        if (malformedInstruction(result)) {
            return ValidatorResult.createUnsuccessfulResult();
        }

        return ValidatorResult.createSuccessfulResult(result.getTokens());
    }

    private boolean malformedInstruction(TokenizerResult result) {
        List<Token> tokens = result.getTokens();
        Operations operation = Operations.valueOf(result.getOperation());

        switch (operation) {
            case ADD_NODE:
                if (malformedAddNodeCommand(tokens)) {
                    return false;
                }
                break;
            case REMOVE_NODE:
                if (malformedRemoveNodeCommand(tokens)) {
                    return false;
                }
                break;
            case ADD_EDGE:
                if (malformedAddEdgeCommand(tokens)) {
                    return false;
                }
                break;
            case REMOVE_EDGE:
                if (malformedRemoveEdgeCommand(tokens)) {
                    return false;
                }
                break;
            case NEW_GRAPH:
                if (malformedNewGraphCommand(tokens)) {
                    return false;
                }
                break;
            case DISPLAY:
                if (malformedDisplayCommand(tokens)) {
                    return false;
                }
                break;
            case HELP:
                if (malformedHelpCommand(tokens)) {
                    return false;
                }
                break;
            case QUIT:
                if (malformedQuitCommand(tokens)) {
                    return false;
                }
                break;
        }

        return true;
    }

    private boolean malformedQuitCommand(List<Token> tokens) {
        return tokens.size() == 1;
    }

    private boolean malformedHelpCommand(List<Token> tokens) {
        return tokens.size() == 1;
    }

    private boolean malformedRemoveEdgeCommand(List<Token> tokens) {
        return tokens.size() == 3;
    }

    private boolean malformedRemoveNodeCommand(List<Token> tokens) {
        return tokens.size() == 3;
    }

    private boolean malformedDisplayCommand(List<Token> tokens) {
        return tokens.size() == 2;
    }

    private boolean malformedNewGraphCommand(List<Token> tokens) {
        return tokens.size() == 2;
    }

    private boolean malformedAddEdgeCommand(List<Token> tokens) {
        return tokens.size() == 5;
    }

    private boolean malformedAddNodeCommand(List<Token> tokens) {
        return tokens.size() == 3;
    }

    private boolean isAWellKnownOperation(TokenizerResult result) {
        String operation = result.getOperation();
        return EnumUtils.isValidEnum(Operations.class, operation.toUpperCase());
    }

}
