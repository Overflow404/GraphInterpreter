package command.addedge;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;


public class AddEdgeCommandFactory implements CommandFactory {
	private final static int ADD_EDGE_COMMAND_LENGTH = 5;

	@Override
    public boolean isSupported(String command) {
        return command.equals("add_edge");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != ADD_EDGE_COMMAND_LENGTH) {
			throw new InvalidSyntaxException("Invalid add_edge syntax.");
        }
		String graph = tokens.get(1);
		String edge = tokens.get(2);
		String sourceNode = tokens.get(3);
		String destinationNode = tokens.get(4);
		return new AddEdgeCommand(graph, edge, sourceNode, destinationNode);
    }
}
