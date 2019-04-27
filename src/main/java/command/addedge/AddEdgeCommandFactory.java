package command.addedge;

import command.Command;
import command.CommandFactory;

import java.util.List;

import static interpreter.Constant.ADD_EDGE_COMMAND_LENGTH;

public class AddEdgeCommandFactory implements CommandFactory {
	@Override
    public boolean isSupported(String command) {
        return command.equals("add_edge");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != ADD_EDGE_COMMAND_LENGTH) {
            throw new IllegalStateException("Invalid add_edge syntax.");
        }
		String graphName = tokens.get(1);
		String edgeName = tokens.get(2);
		String sourceNode = tokens.get(3);
		String destinationNode = tokens.get(4);
		return new AddEdgeCommand(graphName, edgeName, sourceNode, destinationNode);
    }
}
