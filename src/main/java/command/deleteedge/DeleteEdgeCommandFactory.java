package command.deleteedge;

import command.Command;
import command.CommandFactory;

import java.util.List;

import static interpreter.Constant.DELETE_EDGE_COMMAND_LENGTH;

public class DeleteEdgeCommandFactory implements CommandFactory {
    @Override
    public boolean isSupported(String command) {
        return command.equals("delete_edge");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != DELETE_EDGE_COMMAND_LENGTH) {
            throw new IllegalStateException("Invalid delete_edge syntax.");
        }
		String graphName = tokens.get(1);
		String edgeName = tokens.get(2);
		return new DeleteEdgeCommand(graphName, edgeName);
    }
}
