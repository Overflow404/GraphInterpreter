package command.addgraph;

import command.Command;
import command.ExecutionContext;
import org.graphstream.graph.implementations.SingleGraph;

public class AddGraphCommand implements Command {

    private String graphName;

    AddGraphCommand(String graphName) {
        this.graphName = graphName;
    }

    @Override
    public void execute(ExecutionContext context) {
        if (context.containsGraph(graphName)) {
            throw new IllegalStateException("Duplicate graph name are not allowed.");
        }
        context.put(graphName, new SingleGraph(graphName));
        System.out.println("Successfully executed add_graph.");
    }
}
