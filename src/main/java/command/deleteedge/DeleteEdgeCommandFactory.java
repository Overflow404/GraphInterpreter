package command.deleteedge;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class DeleteEdgeCommandFactory implements CommandFactory {
    private final static int DELETE_EDGE_COMMAND_LENGTH = 3;

    @Override
    public boolean isSupported(String command) {
        return command.equals("delete_edge");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != DELETE_EDGE_COMMAND_LENGTH) {
            throw new InvalidSyntaxException("Invalid delete_edge syntax.");
        }
        String graph = tokens.get(1);
        String edge = tokens.get(2);
        return new DeleteEdgeCommand(graph, edge);
    }
}
