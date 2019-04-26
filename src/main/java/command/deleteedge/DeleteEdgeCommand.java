package command.deleteedge;

import command.Command;
import command.ExecutionContext;

public class DeleteEdgeCommand implements Command {

    private String graphName;
    private String edgeName;

    DeleteEdgeCommand(String graphName, String edgeName) {
        this.graphName = graphName;
        this.edgeName = edgeName;
    }

    @Override
    public void execute(ExecutionContext context) {
        try {
            context.deleteEdge(graphName, edgeName);
            System.out.println("Successfully executed delete_edge.");
        } catch (Exception e) {
            System.out.println("Graph or edge doesn't exist.");
        }
    }
}
