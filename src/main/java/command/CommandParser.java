package command;

import command.addedge.AddEdgeCommandFactory;
import command.addgraph.AddGraphCommandFactory;
import command.addnode.AddNodeCommandFactory;
import command.bfs.BfsCommandFactory;
import command.deleteedge.DeleteEdgeCommandFactory;
import command.deletegraph.DeleteGraphCommandFactory;
import command.deletenode.DeleteNodeCommandFactory;
import command.dfs.DfsCommandFactory;
import command.display.DisplayCommandFactory;
import command.help.HelpCommandFactory;
import command.printneighbours.PrintNeighboursCommandFactory;
import command.quit.QuitCommandFactory;

import java.util.Arrays;
import java.util.List;

public class CommandParser {
    private List<CommandFactory> factories = Arrays.asList(
            new AddGraphCommandFactory(),
            new DeleteGraphCommandFactory(),
            new AddEdgeCommandFactory(),
            new AddNodeCommandFactory(),
            new DeleteNodeCommandFactory(),
            new DeleteEdgeCommandFactory(),
            new PrintNeighboursCommandFactory(),
            new BfsCommandFactory(),
            new DfsCommandFactory(),
            new DisplayCommandFactory(),
            new HelpCommandFactory(),
            new QuitCommandFactory()
    );

    public Command parse(List<String> tokens) {
        String command = tokens.get(0);
        for (CommandFactory factory : factories) {
            if (factory.isSupported(command)) {
                return factory.parse(tokens);
            }
        }
        throw new IllegalArgumentException("Unknown command " + command);
    }
}
