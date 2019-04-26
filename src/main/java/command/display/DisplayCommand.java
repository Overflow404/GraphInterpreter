package command.display;

import command.Command;
import command.ExecutionContext;

public class DisplayCommand implements Command {

    private String graphName;

    DisplayCommand(String graphName) {
        this.graphName = graphName;
    }

    @Override
    public void execute(ExecutionContext context) {
        try {
            context.display(graphName);
            System.out.println("Successfully executed display.");
        } catch (Exception e) {
            System.out.println("Graph doesn't exist.");
        }
    }
}
