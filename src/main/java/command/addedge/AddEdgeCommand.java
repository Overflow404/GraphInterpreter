package command.addedge;

import command.Command;
import command.ExecutionContext;

public class AddEdgeCommand implements Command {

    private String graphName;
    private String edgeName;
    private String sourceNode;
    private String destinationNode;

    public AddEdgeCommand(String graphName, String edgeName, String sourceNode, String destinationNode) {
        this.graphName = graphName;
        this.edgeName = edgeName;
        this.sourceNode = sourceNode;
        this.destinationNode = destinationNode;
    }

    @Override
    public void execute(ExecutionContext context) {
        try {
            context.addEdge(graphName, edgeName, sourceNode, destinationNode);
            System.out.println("Successfully executed add_edge.");
        } catch (Exception e) {
            System.out.println("Graph or nodes doesn't exist or edge already exist.");
        }
    }
}
