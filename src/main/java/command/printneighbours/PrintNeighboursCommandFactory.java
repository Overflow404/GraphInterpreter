package command.printneighbours;

import command.Command;
import command.CommandFactory;
import exception.InvalidSyntaxException;

import java.util.List;

public class PrintNeighboursCommandFactory implements CommandFactory {
    private final static int PRINT_NEIGHBOURS_COMMAND_LENGTH = 3;

    @Override
    public boolean isSupported(String command) {
        return command.equals("print_neighbours");
    }

    @Override
    public Command parse(List<String> tokens) {
        if (tokens.size() != PRINT_NEIGHBOURS_COMMAND_LENGTH) {
            throw new InvalidSyntaxException("Invalid print_neighbours syntax.");
        }
        String graph = tokens.get(1);
        String node = tokens.get(2);
        return new PrintNeighboursCommand(graph, node);
    }
}
