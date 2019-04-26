package command.quit;

import command.Command;
import command.CommandFactory;
import command.help.HelpCommand;
import java.util.List;

import static interpreter.Constant.QUIT_COMMAND_LENGTH;

public class QuitCommandFactory implements CommandFactory {
    @Override
    public boolean isSupported(String command) {
        return command.equals("quit");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != QUIT_COMMAND_LENGTH) {
            throw new IllegalStateException("Invalid quit syntax.");
        }
        return new QuitCommand();
    }
}
