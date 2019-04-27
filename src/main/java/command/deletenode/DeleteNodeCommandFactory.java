package command.deletenode;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class DeleteNodeCommandFactory implements CommandFactory {
	private final static int DELETE_NODE_COMMAND_LENGTH = 3;

    @Override
    public boolean isSupported(String command) {
        return command.equals("delete_node");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != DELETE_NODE_COMMAND_LENGTH) {
			throw new InvalidSyntaxException("Invalid delete_node syntax.");
        }
		String graph = tokens.get(1);
		String node = tokens.get(2);
		return new DeleteNodeCommand(graph, node);
    }
}
