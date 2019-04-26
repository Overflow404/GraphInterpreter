package command.deletegraph;

import command.Command;
import command.ExecutionContext;

public class DeleteGraphCommand implements Command {

    private String graphName;

    DeleteGraphCommand(String graphName) {
        this.graphName = graphName;
    }

    @Override
    public void execute(ExecutionContext context) {
        if (context.containsGraph(graphName)) {
            context.remove(graphName);
            System.out.println("Successfully executed delete_graph.");
        } else {
            throw new IllegalStateException("This graph name doesn't exist.");
        }
    }
}
