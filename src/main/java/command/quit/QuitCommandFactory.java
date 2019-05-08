package command.quit;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class QuitCommandFactory implements CommandFactory {
    private final static int QUIT_COMMAND_LENGTH = 1;

    @Override
    public boolean isSupported(String command) {
        return command.equals("quit");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != QUIT_COMMAND_LENGTH) {
            throw new InvalidSyntaxException("Invalid quit syntax.");
        }
        return new QuitCommand();
    }
}
