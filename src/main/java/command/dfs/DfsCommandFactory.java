package command.dfs;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;
import java.util.List;

public class DfsCommandFactory implements CommandFactory {

	private final static int DFS_COMMAND_LENGTH = 3;

	@Override
	public boolean isSupported(String command) {
		return command.equals("dfs");
	}

	@Override
	public Command parse(List<String> tokens) {
		if (tokens.size() != DFS_COMMAND_LENGTH) {
			throw new InvalidSyntaxException("Invalid dfs syntax.");
		}

		String graph = tokens.get(1);
		String sourceNode = tokens.get(2);
		return new DfsCommand(graph, sourceNode);
	}
}
