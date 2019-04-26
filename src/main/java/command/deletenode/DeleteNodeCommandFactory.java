package command.deletenode;

import command.Command;
import command.CommandFactory;
import command.addnode.AddNodeCommand;

import java.util.List;

import static interpreter.Constant.DELETE_NODE_COMMAND_LENGTH;

public class DeleteNodeCommandFactory implements CommandFactory {
    @Override
    public boolean isSupported(String command) {
        return command.equals("delete_node");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != DELETE_NODE_COMMAND_LENGTH) {
            throw new IllegalStateException("Invalid delete_node syntax.");
        }
        return new DeleteNodeCommand(tokens.get(1), tokens.get(2));
    }
}
