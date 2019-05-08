package command.display;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class DisplayCommandFactory implements CommandFactory {
    private final static int DISPLAY_COMMAND_LENGTH = 2;

    @Override
    public boolean isSupported(String command) {
        return command.equals("display");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != DISPLAY_COMMAND_LENGTH) {
            throw new InvalidSyntaxException("Invalid display syntax.");
        }
        String graph = tokens.get(1);
        return new DisplayCommand(graph);
    }
}
