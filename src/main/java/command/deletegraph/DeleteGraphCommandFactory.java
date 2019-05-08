package command.deletegraph;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class DeleteGraphCommandFactory implements CommandFactory {
    private final static int DELETE_GRAPH_COMMAND_LENGTH = 2;

    @Override
    public boolean isSupported(String command) {
        return command.equals("delete_graph");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != DELETE_GRAPH_COMMAND_LENGTH) {
            throw new InvalidSyntaxException("Invalid delete_graph syntax.");
        }
        String graph = tokens.get(1);
        return new DeleteGraphCommand(graph);
    }
}
