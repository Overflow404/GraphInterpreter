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
        return new AddEdgeCommand(tokens.get(1), tokens.get(2), tokens.get(3), tokens.get(4));
    }
}
