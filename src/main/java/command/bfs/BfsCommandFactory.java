package command.bfs;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class BfsCommandFactory implements CommandFactory {

	private final static int BFS_COMMAND_LENGTH = 3;

	@Override
	public boolean isSupported(String command) {
		return command.equals("bfs");
	}

	@Override
	public Command parse(List<String> tokens) {
		if (tokens.size() != BFS_COMMAND_LENGTH) {
			throw new InvalidSyntaxException("Invalid bfs syntax.");
		}

		String graph = tokens.get(1);
		String sourceNode = tokens.get(2);
		return new BfsCommand(graph, sourceNode);
	}
}
