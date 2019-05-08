package command.help;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class HelpCommandFactory implements CommandFactory {
    private final static int HELP_COMMAND_LENGTH = 1;

    @Override
    public boolean isSupported(String command) {
        return command.equals("help");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != HELP_COMMAND_LENGTH) {
            throw new InvalidSyntaxException("Invalid help syntax.");
        }
        return new HelpCommand();
    }
}
