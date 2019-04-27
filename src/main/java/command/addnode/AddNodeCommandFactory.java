package command.addnode;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class AddNodeCommandFactory implements CommandFactory {
	private final static int ADD_NODE_COMMAND_LENGTH = 3;

    @Override
    public boolean isSupported(String command) {
        return command.equals("add_node");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != ADD_NODE_COMMAND_LENGTH) {
			throw new InvalidSyntaxException("Invalid add_node syntax.");
        }
		String graph = tokens.get(1);
		String node = tokens.get(2);
		return new AddNodeCommand(graph, node);
    }
}
