package command.help;

import command.Command;
import command.CommandFactory;
import java.util.List;

import static interpreter.Constant.HELP_COMMAND_LENGTH;

public class HelpCommandFactory implements CommandFactory {
    @Override
    public boolean isSupported(String command) {
        return command.equals("help");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != HELP_COMMAND_LENGTH) {
            throw new IllegalStateException("Invalid help syntax.");
        }
        return new HelpCommand();
    }
}
