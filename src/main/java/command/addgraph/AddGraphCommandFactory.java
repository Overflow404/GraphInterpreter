package command.addgraph;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class AddGraphCommandFactory implements CommandFactory {
	private final static int ADD_GRAPH_COMMAND_LENGTH = 2;

	@Override
	public boolean isSupported(String command) {
		return command.equals("add_graph");
	}

	@Override
	public Command parse(List<String> tokens) {
		if (tokens.size() != ADD_GRAPH_COMMAND_LENGTH) {
			throw new InvalidSyntaxException("Invalid add_graph syntax.");
		}
		String graph = tokens.get(1);
		return new AddGraphCommand(graph);
	}
}
