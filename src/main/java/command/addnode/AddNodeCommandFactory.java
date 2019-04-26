package command.addnode;

import command.Command;
import command.CommandFactory;

import java.util.List;

import static interpreter.Constant.ADD_NODE_COMMAND_LENGTH;

public class AddNodeCommandFactory implements CommandFactory {
    @Override
    public boolean isSupported(String command) {
        return command.equals("add_node");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != ADD_NODE_COMMAND_LENGTH) {
            throw new IllegalStateException("Invalid add_node syntax.");
        }
        return new AddNodeCommand(tokens.get(1), tokens.get(2));
    }
}
