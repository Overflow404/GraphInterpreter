package command.display;

import command.Command;
import command.CommandFactory;

import java.util.List;

import static interpreter.Constant.DISPLAY_COMMAND_LENGTH;

public class DisplayCommandFactory implements CommandFactory {
    @Override
    public boolean isSupported(String command) {
        return command.equals("display");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != DISPLAY_COMMAND_LENGTH) {
            throw new IllegalStateException("Invalid display syntax.");
        }
		String graphName = tokens.get(1);
		return new DisplayCommand(graphName);
    }
}
