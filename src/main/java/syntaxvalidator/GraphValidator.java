package syntaxvalidator;

import Utils.Utils;
import operations.Operations;
import org.apache.commons.lang3.EnumUtils;
import tokenizer.Token;
import tokenizer.TokenizerResult;
import java.util.List;

public class GraphValidator implements SyntaxValidator {

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
            case NEIGHBOURS:
                if (malformedNeighboursCommand(tokens)) {
                    return false;
                }
                break;
            case BFS:
                if (malformedBfsCommand(tokens)) {
                    return false;
                }
                break;
            case DFS:
                if (malformedDfsCommand(tokens)) {
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

    private boolean malformedDfsCommand(List<Token> tokens) {
        return tokens.size() == Utils.DFS_COMMAND_LENGTH;
    }

    private boolean malformedBfsCommand(List<Token> tokens) {
        return tokens.size() == Utils.BFS_COMMAND_LENGTH;
    }

    private boolean malformedNeighboursCommand(List<Token> tokens) {
        return tokens.size() == Utils.NEIGHBOURS_COMMAND_LENGTH;
    }

    private boolean malformedQuitCommand(List<Token> tokens) {
        return tokens.size() == Utils.QUIT_COMMAND_LENGTH;
    }

    private boolean malformedHelpCommand(List<Token> tokens) {
        return tokens.size() == Utils.HELP_COMMAND_LENGTH;
    }

    private boolean malformedRemoveEdgeCommand(List<Token> tokens) {
        return tokens.size() == Utils.REMOVE_EDGE_COMMAND_LENGTH;
    }

    private boolean malformedRemoveNodeCommand(List<Token> tokens) {
        return tokens.size() == Utils.REMOVE_NODE_COMMAND_LENGTH;
    }

    private boolean malformedDisplayCommand(List<Token> tokens) {
        return tokens.size() == Utils.DISPLAY_COMMAND_LENGTH;
    }

    private boolean malformedNewGraphCommand(List<Token> tokens) {
        return tokens.size() == Utils.NEW_GRAPH_COMMAND_LENGTH;
    }

    private boolean malformedAddEdgeCommand(List<Token> tokens) {
        return tokens.size() == Utils.ADD_EDGE_COMMAND_LENGTH;
    }

    private boolean malformedAddNodeCommand(List<Token> tokens) {
        return tokens.size() == Utils.ADD_NODE_COMMAND_LENGTH;
    }

    private boolean isAWellKnownOperation(TokenizerResult result) {
        String operation = result.getOperation();
        return EnumUtils.isValidEnum(Operations.class, operation.toUpperCase());
    }

}
