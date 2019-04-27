package command.addgraph;

import command.Command;
import command.CommandFactory;

import java.util.List;

import static interpreter.Constant.ADD_GRAPH_COMMAND_LENGTH;

public class AddGraphCommandFactory implements CommandFactory {
	@Override
	public boolean isSupported(String command) {
		return command.equals("add_graph");
	}

	@Override
	public Command parse(List<String> tokens) {
		if (tokens.size() != ADD_GRAPH_COMMAND_LENGTH) {
			throw new IllegalStateException("Invalid add_graph syntax.");
		}
		String graphName = tokens.get(1);
		return new AddGraphCommand(graphName);
	}
}
