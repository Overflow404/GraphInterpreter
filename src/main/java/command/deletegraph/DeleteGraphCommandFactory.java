package command.deletegraph;

import command.Command;
import command.CommandFactory;

import java.util.List;

import static interpreter.Constant.DELETE_GRAPH_COMMAND_LENGTH;

public class DeleteGraphCommandFactory implements CommandFactory {
    @Override
    public boolean isSupported(String command) {
        return command.equals("delete_graph");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != DELETE_GRAPH_COMMAND_LENGTH) {
            throw new IllegalStateException("Invalid delete_graph syntax.");
        }
        return new DeleteGraphCommand(tokens.get(1));
    }
}
